package company.amazon.ood.elevator;

import java.util.*;


public class FindElevator {
    enum Direction {
        UP, DOWN
    }

    enum Status {
        UP, DOWN, IDLE
    }

    class Request {
        int level;

        public Request(int level) {
            this.level = level;
        }
    }

    class Elevator {
        int curFloor;
        Set<Integer> upStops = new HashSet<>();
        Set<Integer> downStops = new HashSet<>();
        Status status;

        public Elevator(int floorCount) {
            this.curFloor = 1;
            status = Status.IDLE;
        }

        void handleRequest(Request request) {
            if (request.level > curFloor) {
                upStops.add(request.level);
            } else {
                downStops.add(request.level);
            }
            if (status == Status.IDLE) {
                status = request.level < curFloor ? Status.DOWN : Status.UP;
            }
            run();
        }

        private void run() {
            if (status == Status.IDLE) return;
            if (status == Status.UP) {
                for (int i = curFloor + 1; i <= floorNum; i++) {
                    if (upStops.contains(i)) {
                        curFloor = i;
                        upStops.remove(i);
                    }
                }
                if (noRequest(Status.DOWN)) {
                    status = Status.IDLE;
                } else {
                    status = Status.DOWN;
                }
            } else {
                for (int i = curFloor; i > 0; i--) {
                    if (downStops.contains(i)) {
                        curFloor = i;
                        downStops.remove(i);
                    }
                }
                if (noRequest(Status.UP)) {
                    status = Status.IDLE;
                } else {
                    status = Status.UP;
                }
            }
        }

        private boolean noRequest(Status status) {
            if (status == Status.IDLE) return true;
            if (status == Status.DOWN) {
                return downStops.isEmpty();
            } else {
                return upStops.isEmpty();
            }
        }
    }

    TreeMap<Integer, LinkedList<Elevator>> floorMap = new TreeMap<>();
    int floorNum;

    public FindElevator(int floorNum, int elevatorNum) {
        this.floorNum = floorNum;
        floorMap.put(1, new LinkedList<>());
        for (int i = 1; i <= elevatorNum; i++) {
            floorMap.get(1).add(new Elevator(floorNum));
        }
    }

    Elevator findNearestElevator(int curFloor) {
        if (floorMap.containsKey(curFloor) && floorMap.get(curFloor).size() > 0) {
            return floorMap.get(curFloor).removeFirst();
        }
        Integer lowerFloor = floorMap.floorKey(curFloor);
        Integer higherFloor = floorMap.ceilingKey(curFloor);
        int minDist = Integer.MAX_VALUE;
        int floor = 0;
        if (lowerFloor != null && curFloor - lowerFloor < minDist) {
            floor = lowerFloor;
            minDist = curFloor - lowerFloor;
        }
        if (higherFloor != null && higherFloor - curFloor < minDist) {
            floor = higherFloor;
            minDist = higherFloor - curFloor;
        }
        return floorMap.get(floor).removeFirst();
    }

    void goToTargetFloor(Elevator elevator, int targetFloor) {
        if (targetFloor < 1 || targetFloor > floorNum) return;
        elevator.handleRequest(new Request(targetFloor));
        floorMap.putIfAbsent(targetFloor, new LinkedList<>());
        floorMap.get(targetFloor).addLast(elevator);
    }
}
