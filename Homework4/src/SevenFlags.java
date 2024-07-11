import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SevenFlags {

    public static void main(String[] args) throws Exception{
        System.out.println("Welcome to Seven Flags");

        Scanner scanner = new Scanner(System.in);

        int dayCounter = 0;
        // Construct list
        Ride[] rides = new Ride[4];
        // Construct Persons
        // REGULAR
        System.out.println("Please enter the number of regular customers: ");
        int regCos = scanner.nextInt();

        ArrayList<Person> goldInitLine2 = new ArrayList<Person>();
        ArrayList<Person> goldInitLine3 = new ArrayList<Person>();
        ArrayList<Person> silverInitLine2 = new ArrayList<Person>();

        ArrayList<Person> regularUserLine = new ArrayList<Person>();
        ArrayList<Person> regInitLine = new ArrayList<Person>();
        for (int i = 1; i <= regCos; i++) {
            Person regular = new Person(i);
            regular.setNumber(i);
            regular.setMembership("Regular");
            regular.setMaxlines(1);
            regular.setStatus(Status.Available);
            regInitLine.add(regular);
            regularUserLine.add(regular);
        }

        // SILVER
        System.out.println("Please enter the number of silver customers: ");
        int silverCos = scanner.nextInt();

        ArrayList<Person> silverInitLine = new ArrayList<Person>();
        ArrayList<Person> silverUserLine = new ArrayList<Person>();
        for (int i = 1; i <= silverCos; i++) {
            Person silver = new Person(i);
            silver.setNumber(i);
            silver.setMembership("Silver");
            silver.setMaxlines(2);
            silver.setStatus(Status.Available);
            silverInitLine.add(silver);
            silverInitLine2.add(silver);
            silverUserLine.add(silver);

        }

        // GOLD
        System.out.println("Please enter the number of gold customers: ");

        ArrayList<Person> goldInitLine = new ArrayList<Person>();
        ArrayList<Person> goldUserLine = new ArrayList<Person>();
        int goldCos = scanner.nextInt();
        for (int i = 1; i <= goldCos; i++) {
            Person gold = new Person(i);
            gold.setNumber(i);
            gold.setMembership("Gold");
            gold.setMaxlines(3);
            gold.setStatus(Status.Available);
            goldInitLine.add(gold);
            goldInitLine2.add(gold);
            goldInitLine3.add(gold);
            goldUserLine.add(gold);
        }

        System.out.println("Please enter simulation length: ");
        int simLength = scanner.nextInt();

        // For BSOD
        System.out.println("Please enter the duration of Blue Scream of Death (minutes): ");
        int BSOD_duration = scanner.nextInt();
        System.out.println("Please enter the capacity of Blue Scream of Death: ");
        int BSOD_capacity = scanner.nextInt();
        System.out.println("Please enter the holding queue size for Blue Scream of Death: ");
        int BSOD_holdingQueueSize = scanner.nextInt();

        Ride BSOD = new Ride();
        BSOD.setDuration(BSOD_duration);
        BSOD.setTimeLeft(BSOD_duration);
        BSOD.setName("BSOD");
        VirtualLine Bsod_virtualLine = new VirtualLine();
        BSOD.setVirtalLine(Bsod_virtualLine);
        HoldingQueue BSOD_holdingQueue = new HoldingQueue();
        BSOD.setHoldingQueue(BSOD_holdingQueue);
        ArrayList<Person> BSOD_peopleOn = new ArrayList<Person>();
        BSOD.setPeopleOnRide(BSOD_peopleOn);
        rides[0] = BSOD;

        // For KK
        System.out.println("Please enter the duration of Kingda Knuth (minutes): ");
        int KK_duration = scanner.nextInt();
        System.out.println("Please enter the capacity of Kingda Knuth: ");
        int KK_capacity = scanner.nextInt();
        System.out.println("Please enter the holding queue size for Kingda Knuth: ");
        int KK_holdingQueueSize = scanner.nextInt();

        Ride KK = new Ride();
        KK.setDuration(KK_duration);
        KK.setTimeLeft(KK_duration);
        KK.setName("KK");
        VirtualLine KK_virtualLine = new VirtualLine();
        KK.setVirtalLine(KK_virtualLine);
        HoldingQueue KK_holdingQueue = new HoldingQueue();
        KK.setHoldingQueue(KK_holdingQueue);
        ArrayList<Person> KK_peopleOn = new ArrayList<Person>();
        KK.setPeopleOnRide(KK_peopleOn);
        rides[1] = KK;

        System.out.println("Please enter the duration of i386 Tower of Terror (minutes): ");
        int ToT_duration = scanner.nextInt();
        System.out.println("Please enter the capacity of i386 Tower of Terror: ");
        int ToT_capacity = scanner.nextInt();
        System.out.println("Please enter the holding queue size for i386 Tower of Terror: ");
        int ToT_holdingQueueSize = scanner.nextInt();

        Ride ToT = new Ride();
        ToT.setDuration(ToT_duration);
        ToT.setTimeLeft(ToT_duration);
        ToT.setName("ToT");
        VirtualLine ToT_virtualLine = new VirtualLine();
        ToT.setVirtalLine(ToT_virtualLine);
        HoldingQueue ToT_holdingQueue = new HoldingQueue();
        ToT.setHoldingQueue(ToT_holdingQueue);
        ArrayList<Person> ToT_peopleOn = new ArrayList<Person>();
        ToT.setPeopleOnRide(ToT_peopleOn);
        rides[2] = ToT;

        System.out.println("Please enter the duration of GeForce (minutes): ");
        int GF_duration = scanner.nextInt();
        System.out.println("Please enter the capacity of GeForce: ");
        int GF_capacity = scanner.nextInt();
        System.out.println("Please enter the holding queue size for GeForce: ");
        int GF_holdingQueueSize = scanner.nextInt();

        Ride GF = new Ride();
        GF.setDuration(GF_duration);
        GF.setTimeLeft(GF_duration);
        GF.setName("GF");
        VirtualLine GF_virtualLine = new VirtualLine();
        GF.setVirtalLine(GF_virtualLine);
        HoldingQueue GF_holdingQueue = new HoldingQueue();
        GF.setHoldingQueue(GF_holdingQueue);
        ArrayList<Person> GF_peopleOn = new ArrayList<Person>();
        GF.setPeopleOnRide(GF_peopleOn);
        rides[3] = GF;

        while (goldInitLine.isEmpty() != true) {
            Ride choosen;
            choosen = RandomGenerator.selectRide(rides);
            if (choosen == BSOD) {
                if (BSOD_peopleOn.size() < BSOD_capacity) {
                    BSOD_peopleOn.add(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.OnRide);
                } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                    BSOD.getHoldingQueue().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    BSOD.getVirtualLine().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == KK) {
                if (KK_peopleOn.size() < KK_capacity) {
                    KK_peopleOn.add(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.OnRide);
                } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                    KK.getHoldingQueue().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    KK.getVirtualLine().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == ToT) {
                if (ToT_peopleOn.size() < ToT_capacity) {
                    ToT_peopleOn.add(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.OnRide);
                } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                    ToT.getHoldingQueue().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    ToT.getVirtualLine().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == GF) {
                if (GF_peopleOn.size() < GF_capacity) {
                    GF_peopleOn.add(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.OnRide);
                } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                    GF.getHoldingQueue().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                    goldInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    GF.getVirtualLine().enqueue(goldInitLine.getFirst());
                    goldInitLine.getFirst().addToLine(choosen);
                }
            }
            
            goldInitLine.remove(0);
        }
        while (silverInitLine.isEmpty() != true) {
            Ride choosen;
            choosen = RandomGenerator.selectRide(rides);
            if (choosen == BSOD) {
                if (BSOD_peopleOn.size() < BSOD_capacity) {
                    BSOD_peopleOn.add(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.OnRide);
                } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                    BSOD.getHoldingQueue().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    BSOD.getVirtualLine().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == KK) {
                if (KK_peopleOn.size() < KK_capacity) {
                    KK_peopleOn.add(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.OnRide);
                } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                    KK.getHoldingQueue().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    KK.getVirtualLine().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == ToT) {
                if (ToT_peopleOn.size() < ToT_capacity) {
                    ToT_peopleOn.add(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.OnRide);
                } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                    ToT.getHoldingQueue().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    ToT.getVirtualLine().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == GF) {
                if (GF_peopleOn.size() < GF_capacity) {
                    GF_peopleOn.add(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.OnRide);
                } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                    GF.getHoldingQueue().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                    silverInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    GF.getVirtualLine().enqueue(silverInitLine.getFirst());
                    silverInitLine.getFirst().addToLine(choosen);
                }
            }

            silverInitLine.remove(0);
        }
        while (regInitLine.isEmpty() != true) {
            Ride choosen;
            choosen = RandomGenerator.selectRide(rides);
            if (choosen == BSOD) {
                if (BSOD_peopleOn.size() < BSOD_capacity) {
                    BSOD_peopleOn.add(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.OnRide);
                } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                    BSOD.getHoldingQueue().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    BSOD.getVirtualLine().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == KK) {
                if (KK_peopleOn.size() < KK_capacity) {
                    KK_peopleOn.add(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.OnRide);
                } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                    KK.getHoldingQueue().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    KK.getVirtualLine().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == ToT) {
                if (ToT_peopleOn.size() < ToT_capacity) {
                    ToT_peopleOn.add(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.OnRide);
                } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                    ToT.getHoldingQueue().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    ToT.getVirtualLine().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                }
            }
            if (choosen == GF) {
                if (GF_peopleOn.size() < GF_capacity) {
                    GF_peopleOn.add(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.OnRide);
                } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                    GF.getHoldingQueue().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                    regInitLine.getFirst().setStatus(Status.Holding);
                } else {
                    GF.getVirtualLine().enqueue(regInitLine.getFirst());
                    regInitLine.getFirst().addToLine(choosen);
                }
            }

            regInitLine.remove(0);
        }
        while (goldInitLine2.isEmpty() != true) {
            Ride choosen;
            choosen = RandomGenerator.selectRide(rides);
            if (choosen == BSOD) {
                if (BSOD_peopleOn.size() < BSOD_capacity) {
                    BSOD_peopleOn.add(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                    BSOD.getHoldingQueue().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    BSOD.getVirtualLine().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                }
            }
            if (choosen == KK) {
                if (KK_peopleOn.size() < KK_capacity) {
                    KK_peopleOn.add(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                    KK.getHoldingQueue().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    KK.getVirtualLine().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                }
            }
            if (choosen == ToT) {
                if (ToT_peopleOn.size() < ToT_capacity) {
                    ToT_peopleOn.add(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                    ToT.getHoldingQueue().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    ToT.getVirtualLine().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                }
            }
            if (choosen == GF) {
                if (GF_peopleOn.size() < GF_capacity) {
                    GF_peopleOn.add(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                    GF.getHoldingQueue().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                    goldInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    GF.getVirtualLine().enqueue(goldInitLine2.getFirst());
                    goldInitLine2.getFirst().addToLine(choosen);
                }
            }

            goldInitLine2.remove(0);
        }
        while (silverInitLine2.isEmpty() != true) {
            Ride choosen;
            choosen = RandomGenerator.selectRide(rides);
            if (choosen == BSOD) {
                if (BSOD_peopleOn.size() < BSOD_capacity) {
                    BSOD_peopleOn.add(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                    BSOD.getHoldingQueue().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    BSOD.getVirtualLine().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                }
            }
            if (choosen == KK) {
                if (KK_peopleOn.size() < KK_capacity) {
                    KK_peopleOn.add(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                    KK.getHoldingQueue().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    KK.getVirtualLine().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                }
            }
            if (choosen == ToT) {
                if (ToT_peopleOn.size() < ToT_capacity) {
                    ToT_peopleOn.add(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                    ToT.getHoldingQueue().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    ToT.getVirtualLine().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                }
            }
            if (choosen == GF) {
                if (GF_peopleOn.size() < GF_capacity) {
                    GF_peopleOn.add(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.OnRide);
                } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                    GF.getHoldingQueue().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                    silverInitLine2.getFirst().setStatus(Status.Holding);
                } else {
                    GF.getVirtualLine().enqueue(silverInitLine2.getFirst());
                    silverInitLine2.getFirst().addToLine(choosen);
                }
            }

            silverInitLine2.remove(0);
        }
        while (goldInitLine3.isEmpty() != true) {
            Ride choosen;
            choosen = RandomGenerator.selectRide(rides);
            if (choosen == BSOD) {
                if (BSOD_peopleOn.size() < BSOD_capacity) {
                    BSOD_peopleOn.add(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.OnRide);
                } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                    BSOD.getHoldingQueue().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.Holding);
                } else {
                    BSOD.getVirtualLine().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                }
            }
            if (choosen == KK) {
                if (KK_peopleOn.size() < KK_capacity) {
                    KK_peopleOn.add(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.OnRide);
                } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                    KK.getHoldingQueue().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.Holding);
                } else {
                    KK.getVirtualLine().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                }
            }
            if (choosen == ToT) {
                if (ToT_peopleOn.size() < ToT_capacity) {
                    ToT_peopleOn.add(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.OnRide);
                } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                    ToT.getHoldingQueue().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.Holding);
                } else {
                    ToT.getVirtualLine().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                }
            }
            if (choosen == GF) {
                if (GF_peopleOn.size() < GF_capacity) {
                    GF_peopleOn.add(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.OnRide);
                } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                    GF.getHoldingQueue().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                    goldInitLine3.getFirst().setStatus(Status.Holding);
                } else {
                    GF.getVirtualLine().enqueue(goldInitLine3.getFirst());
                    goldInitLine3.getFirst().addToLine(choosen);
                }
            }

            goldInitLine3.remove(0);
        }
        int BSOD_ridesTaken= 0;
        int KK_ridesTaken=0;
        int ToT_ridesTaken =0;
        int GF_ridesTaken =0;
        double regularRidesTaken=0;
        double silverRidesTaken=0;
        double goldRidesTaken=0;
        for (int j = dayCounter; j <= simLength; j++) {
            
            if(BSOD.getTimeLeft()==0){
                BSOD_ridesTaken++;
                ArrayList<Person> reassign = new ArrayList<Person>();
                for (Person i : BSOD_peopleOn) {
                    reassign.add(i);
                    if(i.getMembership()=="Regular"){
                        regularRidesTaken++;
                    }
                    if(i.getMembership()=="Silver"){
                        silverRidesTaken++;
                    }
                    if(i.getMembership()=="Gold"){
                        goldRidesTaken++;
                    }
                    i.getLines().remove(0);
                    i.setStatus(Status.Available);
                }
                BSOD_peopleOn.clear();
                for(int i = 0; i<BSOD_capacity; i++){
                    if(BSOD_holdingQueue.isEmpty()!=true){
                        BSOD_peopleOn.add(BSOD_holdingQueue.peek());
                        BSOD_peopleOn.get(i).setStatus(Status.OnRide);
                        BSOD_holdingQueue.dequeue();
                    }
                }
                for(int i = 0; i<BSOD_holdingQueueSize; i++){
                    if(Bsod_virtualLine.isEmpty()!=true){
                        BSOD.getHoldingQueue().enqueue(Bsod_virtualLine.peek());
                        Bsod_virtualLine.peek().setStatus(Status.Holding);
                        Bsod_virtualLine.dequeue();
                    }
                }
                BSOD.setTimeLeft(BSOD_duration);
                while (reassign.isEmpty() != true) {
                    Ride choosen;
                    choosen = RandomGenerator.selectRide(rides);
                    if (choosen == BSOD) {
                        if (BSOD_peopleOn.size() < BSOD_capacity) {
                            BSOD_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                            BSOD.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            BSOD.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == KK) {
                        if (KK_peopleOn.size() < KK_capacity) {
                            KK_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                            KK.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            KK.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == ToT) {
                        if (ToT_peopleOn.size() < ToT_capacity) {
                            ToT_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                            ToT.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            ToT.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == GF) {
                        if (GF_peopleOn.size() < GF_capacity) {
                            GF_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                            GF.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            GF.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    reassign.remove(0);
                }
            }
            if(KK.getTimeLeft()==0){
                KK_ridesTaken++;
                ArrayList<Person> reassign = new ArrayList<Person>();
                for (Person i : KK_peopleOn) {
                    reassign.add(i);
                    if(i.getMembership()=="Regular"){
                        regularRidesTaken++;
                    }
                    if(i.getMembership()=="Silver"){
                        silverRidesTaken++;
                    }
                    if(i.getMembership()=="Gold"){
                        goldRidesTaken++;
                    }
                    i.getLines().remove(0);
                    i.setStatus(Status.Available);
                }
                KK_peopleOn.clear();
                for(int i = 0; i<KK_capacity; i++){
                    if(KK_holdingQueue.isEmpty()!=true){
                        KK_peopleOn.add(KK_holdingQueue.peek());
                        KK_peopleOn.get(i).setStatus(Status.OnRide);
                        KK_holdingQueue.dequeue();
                    }
                }
                for(int i = 0; i<KK_holdingQueueSize; i++){
                    if(KK_virtualLine.isEmpty()!=true){
                        KK.getHoldingQueue().enqueue(KK_virtualLine.peek());
                        KK_virtualLine.peek().setStatus(Status.Holding);
                        KK_virtualLine.dequeue();
                    }
                }
                KK.setTimeLeft(KK_duration);
                while (reassign.isEmpty() != true) {
                    Ride choosen;
                    choosen = RandomGenerator.selectRide(rides);
                    if (choosen == BSOD) {
                        if (BSOD_peopleOn.size() < BSOD_capacity) {
                            BSOD_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                            BSOD.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            BSOD.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == KK) {
                        if (KK_peopleOn.size() < KK_capacity) {
                            KK_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                            KK.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            KK.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == ToT) {
                        if (ToT_peopleOn.size() < ToT_capacity) {
                            ToT_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                            ToT.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            ToT.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == GF) {
                        if (GF_peopleOn.size() < GF_capacity) {
                            GF_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                            GF.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            GF.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    reassign.remove(0);
                }
            }
            if(ToT.getTimeLeft()==0){
                ToT_ridesTaken++;
                ArrayList<Person> reassign = new ArrayList<Person>();
                for (Person i : ToT_peopleOn) {
                    reassign.add(i);
                    if(i.getMembership()=="Regular"){
                        regularRidesTaken++;
                    }
                    if(i.getMembership()=="Silver"){
                        silverRidesTaken++;
                    }
                    if(i.getMembership()=="Gold"){
                        goldRidesTaken++;
                    }
                    i.getLines().remove(0);
                    i.setStatus(Status.Available);
                }
                ToT_peopleOn.clear();
                for(int i = 0; i<ToT_capacity; i++){
                    if(ToT_holdingQueue.isEmpty()!=true){
                        ToT_peopleOn.add(ToT_holdingQueue.peek());
                        ToT_peopleOn.get(i).setStatus(Status.OnRide);
                        ToT_holdingQueue.dequeue();
                    }
                }
                for(int i = 0; i<ToT_holdingQueueSize; i++){
                    if(ToT_virtualLine.isEmpty()!=true){
                        ToT.getHoldingQueue().enqueue(ToT_virtualLine.peek());
                        ToT_virtualLine.peek().setStatus(Status.Holding);
                        ToT_virtualLine.dequeue();
                    }
                }
                ToT.setTimeLeft(ToT_duration);
                while (reassign.isEmpty() != true) {
                    Ride choosen;
                    choosen = RandomGenerator.selectRide(rides);
                    if (choosen == BSOD) {
                        if (BSOD_peopleOn.size() < BSOD_capacity) {
                            BSOD_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                            BSOD.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            BSOD.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == KK) {
                        if (KK_peopleOn.size() < KK_capacity) {
                            KK_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                            KK.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            KK.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == ToT) {
                        if (ToT_peopleOn.size() < ToT_capacity) {
                            ToT_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                            ToT.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            ToT.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == GF) {
                        if (GF_peopleOn.size() < GF_capacity) {
                            GF_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                            GF.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            GF.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    reassign.remove(0);
                }
            }
            if(GF.getTimeLeft()==0){
                GF_ridesTaken++;
                ArrayList<Person> reassign = new ArrayList<Person>();
                for (Person i : GF_peopleOn) {
                    reassign.add(i);
                    if(i.getMembership()=="Regular"){
                        regularRidesTaken++;
                    }
                    if(i.getMembership()=="Silver"){
                        silverRidesTaken++;
                    }
                    if(i.getMembership()=="Gold"){
                        goldRidesTaken++;
                    }
                    i.getLines().remove(0);
                    i.setStatus(Status.Available);
                }
                GF_peopleOn.clear();
                for(int i = 0; i<GF_capacity; i++){
                    if(GF_holdingQueue.isEmpty()!=true){
                        GF_peopleOn.add(GF_holdingQueue.peek());
                        GF_peopleOn.get(i).setStatus(Status.OnRide);
                        GF_holdingQueue.dequeue();
                    }
                }
                for(int i = 0; i<GF_holdingQueueSize; i++){
                    if(GF_virtualLine.isEmpty()!=true){
                        GF.getHoldingQueue().enqueue(GF_virtualLine.peek());
                        GF_virtualLine.peek().setStatus(Status.Holding);
                        GF_virtualLine.dequeue();
                    }
                }
                GF.setTimeLeft(GF_duration);
                while (reassign.isEmpty() != true) {
                    Ride choosen;
                    choosen = RandomGenerator.selectRide(rides);
                    if (choosen == BSOD) {
                        if (BSOD_peopleOn.size() < BSOD_capacity) {
                            BSOD_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (BSOD.getHoldingQueue().size() < BSOD_holdingQueueSize) {
                            BSOD.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            BSOD.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == KK) {
                        if (KK_peopleOn.size() < KK_capacity) {
                            KK_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (KK.getHoldingQueue().size() < KK_holdingQueueSize) {
                            KK.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            KK.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == ToT) {
                        if (ToT_peopleOn.size() < ToT_capacity) {
                            ToT_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (ToT.getHoldingQueue().size() < ToT_holdingQueueSize) {
                            ToT.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            ToT.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    if (choosen == GF) {
                        if (GF_peopleOn.size() < GF_capacity) {
                            GF_peopleOn.add(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.OnRide);
                        } else if (GF.getHoldingQueue().size() < GF_holdingQueueSize) {
                            GF.getHoldingQueue().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                            reassign.getFirst().setStatus(Status.Holding);
                        } else {
                            GF.getVirtualLine().enqueue(reassign.getFirst());
                            reassign.getFirst().addToLine(choosen);
                        }
                    }
                    reassign.remove(0);
                }
            }
            System.out.println("At Time " + j + ":");
            System.out.println("Blue Scream of Death - Time remaining: " + BSOD.getTimeLeft());

            System.out.print("On Ride: ");
            for (Person i : BSOD_peopleOn) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Holding Queue: ");
            for (Person i : BSOD_holdingQueue.currentArrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Virtual Queue: ");
            for (Person i : Bsod_virtualLine.currentArrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.println("----------------");
            System.out.println("Kingda Knuth - Time remaining: " + KK.getTimeLeft());

            System.out.print("On Ride: ");
            for (Person i : KK_peopleOn) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Holding Queue: ");
            for (Person i : KK_holdingQueue.currentArrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Virtual Queue: ");
            for (Person i : KK_virtualLine.currentArrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.println("----------------");
            System.out.println("i386 Tower of Terror - Time remaining: " + ToT.getTimeLeft());

            System.out.print("On Ride: ");
            for (Person i : ToT_peopleOn) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Holding Queue: ");
            for (Person i : ToT_holdingQueue.currentArrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Virtual Queue: ");
            for (Person i : ToT_virtualLine.currentArrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.println("----------------");
            System.out.println("GeForce - Time remaining: " + GF.getTimeLeft());

            System.out.print("On Ride: ");
            for (Person i : GF_peopleOn) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Holding Queue: ");
            for (Person i : GF_holdingQueue.currentArrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.print("Virtual Queue: ");
            for (Person i : GF_virtualLine.currentArrayList) {
                System.out.print(i + ", ");
            }

            System.out.println();
            System.out.println("----------------");
            System.out.println("Regular Costumers:");
            System.out.println("Num Line Status");
            System.out.println("----------------");
            for (int i = 0; i < regularUserLine.size(); i++) {
                System.out.println(
                        i + 1 + ". " + regularUserLine.get(i).getLines() + " " + regularUserLine.get(i).getStatus());
            }
            System.out.println();
            System.out.println("Silver Costumers:");
            System.out.println("Num Line 1 Line 2 Status");
            System.out.println("----------------");
            for (int i = 0; i < silverUserLine.size(); i++) {
                System.out.println(
                        i + 1 + ". " + silverUserLine.get(i).getLines() + " " + silverUserLine.get(i).getStatus());
            }
            System.out.println();
            System.out.println("Gold Costumers:");
            System.out.println("Num Line 1 Line 2 Line 3 Status");
            System.out.println("-------------------------------");
            for (int i = 0; i < goldUserLine.size(); i++) {
                System.out
                        .println(i + 1 + ". " + goldUserLine.get(i).getLines() + " " + goldUserLine.get(i).getStatus());
            }
            BSOD.setTimeLeft(BSOD.getTimeLeft()-1);
            KK.setTimeLeft(KK.getTimeLeft()-1);
            ToT.setTimeLeft(ToT.getTimeLeft()-1);
            GF.setTimeLeft(GF.getTimeLeft()-1);
        }
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println();
        System.out.println("...........At the end of the simulation:......");
        System.out.println("On average, Gold customers have taken "+f.format(goldRidesTaken/goldCos)+" rides.");
        System.out.println("On average, Silver customers have taken "+f.format(silverRidesTaken/silverCos)+" rides.");
        System.out.println("On average, regular customers have taken "+f.format(regularRidesTaken/regCos)+" rides.");
        System.out.println("BSOD has completed rides for "+BSOD_ridesTaken+" people.");
        System.out.println("KK has completed rides for "+KK_ridesTaken+" people.");
        System.out.println("ToT has completed rides for "+ToT_ridesTaken+" people.");

    }
}
