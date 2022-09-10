package company.amazon.ood2;

import java.util.HashMap;
import java.util.Map;

public class LockerSystem {
    enum PackageSize {
        LARGE, MEDIUM, SMALL
    }

    abstract class Package {
        private String id;
        private PackageSize size;

        public Package(PackageSize size) {
            this.size = size;
        }

        public String getId() {
            return id;
        }

        public PackageSize getSize() {
            return size;
        }
    }

    class LargePackage extends Package {
        public LargePackage() {
            super(PackageSize.LARGE);
        }
    }

    class MediumPackage extends Package {
        public MediumPackage() {
            super(PackageSize.MEDIUM);
        }
    }

    class SmallPackage extends Package {
        public SmallPackage() {
            super(PackageSize.SMALL);
        }
    }

    enum LockerStatus {
        EMPTY, FULL
    }

    class LockerUnit {
        private String id;
        private PackageSize size;
        private LockerStatus status;
        private Package item;

        public LockerUnit(String id, PackageSize size) {
            this.id = id;
            this.size = size;
            this.status = LockerStatus.EMPTY;
        }

        public boolean isEmpty() {
            return status == LockerStatus.EMPTY;
        }

        public boolean canFitPackage(Package item) {
            if (!isEmpty()) return false;
            switch (item.size) {
                case SMALL:
                    return true;
                case MEDIUM:
                    return this.size == PackageSize.MEDIUM || this.size == PackageSize.LARGE;
                default:
                    return this.size == PackageSize.LARGE;
            }
        }

        public boolean assignItem(Package item) {
            if (!canFitPackage(item)) return false;
            this.status = LockerStatus.FULL;
            this.item = item;
            return true;
        }

        public void clearUnit() {
            this.status = LockerStatus.EMPTY;
            this.item = null;
        }
    }

    class LockingTicket {
        private LockerUnit unit;
        private Package aPackage;

        public LockingTicket(LockerUnit unit, Package aPackage) {
            this.unit = unit;
            this.aPackage = aPackage;
        }

        public LockerUnit getUnit() {
            return unit;
        }

        public Package getPackage() {
            return aPackage;
        }
    }

    class Locker {
        Map<String, LockerUnit> fullMap = new HashMap<>();
        Map<String, LockerUnit> emptyMap = new HashMap<>();
        Map<String, LockingTicket> lockingMap = new HashMap<>();

        void addUnit(LockerUnit unit) {
            emptyMap.put(unit.id, unit);
        }

        LockerUnit findUnit(Package p) {
            for (String id : fullMap.keySet()) {
                LockerUnit unit = fullMap.get(id);
                if (unit.canFitPackage(p)) return unit;
            }
            return null;
        }

        boolean assignPackage(Package p) {
            LockerUnit unit = findUnit(p);
            if (unit == null) return false;
            unit.assignItem(p);
            fullMap.put(unit.id, unit);
            emptyMap.remove(unit.id);
            lockingMap.put(p.id, new LockingTicket(unit, p));
            return true;
        }

        Package removePackage(String pid) {
            if (!lockingMap.containsKey(pid)) return null;
            LockingTicket lockingTicket = lockingMap.get(pid);
            Package p = lockingTicket.getPackage();
            LockerUnit unit = lockingTicket.getUnit();
            unit.clearUnit();
            emptyMap.put(unit.id, unit);
            fullMap.remove(unit.id);
            lockingMap.remove(pid);
            return p;
        }
    }
}
