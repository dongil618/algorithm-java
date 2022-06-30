import java.util.HashMap;
import java.util.UUID;

class Bus{
    private int maxPassenger;
    private int currentPassenger;
    private int fee;
    private UUID busNumber;
    private int gasAmount;
    private int currentSpeed;
    private String status;

    public Bus(int maxPassenger, int fee, int gasAmount){
        this.maxPassenger = maxPassenger;
        this.currentPassenger = 0;
        this.fee = fee;
        this.busNumber = UUID.randomUUID();
        this.gasAmount = gasAmount;
        this.currentSpeed = 0;
        this.status = "운행";
    }

    public void changeStatus(){
        checkGasAmount();
        if(this.status == "운행"){
            this.status = "차고지행";
        } else if(this.status == "차고지행"){
            this.status = "운행";
        }
    }

    public void pickUpPassenger(int newPassenger){
        if (checkStatus()){
            int totalPassenger = this.currentPassenger + newPassenger;
            if(totalPassenger <= maxPassenger && this.status == "운행"){
                this.currentPassenger = totalPassenger;
                //System.out.println(currentPassenger);
            } else if(totalPassenger > maxPassenger){
                System.out.println("정원 초과입니다.\n");
            }
        } else {
            System.out.println("차고지행 입니다.\n");
        }
    }

    public boolean checkStatus(){
        if(this.status == "운행"){
            return true;
        } else {
            return false;
        }
    }

    public void speedUp(int newSpeed){
        checkGasAmount();
        this.currentSpeed += newSpeed;
    }

    public void speedDown(int newSpeed){
        checkGasAmount();
        this.currentSpeed -= newSpeed;
    }

    public void checkGasAmount(){
        if (this.gasAmount < 10){
            System.out.println("주유량을 확인해주세요\n 주유가 필요합니다.\n");
        }
    }

    @Override
    public String toString() {
        return "버스번호 : " + this.busNumber.toString() + "\n"
                + "버스 요금 : " + this.fee + "원\n"
                + "최대 승객수 : " + this.maxPassenger + "명\n"
                + "현재 승객수 : " + this.currentPassenger + "명\n"
                + "현재 속도 : " + this.currentSpeed + "km/h\n"
                + "주유량 : " + this.gasAmount + "L\n"
                + "상태 : " + this.status + "\n";
    }
}

class Taxi{
    private String destination;
    private int distanceToDestination;
    private int defaultDistance;
    private int basicCharge;
    private int distanceCharge;
    private UUID taxiNumber;
    private int gasAmount;
    private int currentSpeed;
    private String status;

    public Taxi(int basicCharge, int distanceCharge, int defaultDistance, int gasAmount){
        this.distanceCharge = distanceCharge;
        this.defaultDistance = defaultDistance;
        this.basicCharge = basicCharge;
        this.gasAmount = gasAmount;
        this.taxiNumber = UUID.randomUUID();
        this.currentSpeed = 0;
        this.status = "일반";
    }

    public void startOperation(){
        if(checkGasAmount()){
            System.out.println("운행이 가능합니다.\n");
        } else {
            System.out.println("운행이 불가능합니다.\n");
        }
    }

    public void changeStatus(){
        if(this.status == "운행 중"){
            this.status = "일반";
        } else if(this.status == "일반"){
            this.status = "운행 중";
        }
    }

    public void pickUpPassenger(String destination, int distanceToDestination){
        if (checkStatus() && checkGasAmount()){
            changeStatus();
            this.destination = destination;
            this.distanceToDestination = distanceToDestination;
        } else {
            System.out.println("탑승이 불가합니다.\n");
        }
    }

    public void getOffPassenger(){
        changeStatus();
        this.destination = "";
        this.distanceToDestination = 0;
    }

    public boolean checkStatus(){
        if(this.status == "일반"){
            return true;
        } else {
            return false;
        }
    }

    public void speedUp(int newSpeed){
        this.currentSpeed += newSpeed;
    }

    public void speedDown(int newSpeed){
        this.currentSpeed -= newSpeed;
    }

    public void chargeGas(int newGasAmount){
        this.gasAmount += newGasAmount;
    }

    public boolean checkGasAmount(){
        if (this.gasAmount < 10){
            System.out.println("주유량을 확인해주세요\n주유가 필요합니다.\n");
            return false;
        }
        return true;
    }

    public int calculateTotalCharge(){
        int totalCharge = 0;
        int additionalCharge;
        if(checkPassenger()){
            // 기본 거리가 목적지까지 거리보다 더 길면 그냥 기본 요금만
            if(this.defaultDistance > this.distanceToDestination){
                totalCharge = this.basicCharge;
            } else {
                additionalCharge = (this.distanceToDestination - this.defaultDistance) * this.distanceCharge;
                totalCharge = this.basicCharge + additionalCharge;
            }
        }
        return totalCharge;
    }

    public boolean checkPassenger(){
        if(this.destination != null){
            return true;
        } else {
            System.out.println("승객이 탑승하지 않은 상태입니다.\n");
            return false;
        }
    }

    @Override
    public String toString() {
        return "택시번호 : " + this.taxiNumber.toString() + "\n"
                + "기본 요금 : " + this.basicCharge + "원\n"
                + "거리당 요금 : " + this.distanceCharge + "원\n"
                + "목적지 : " + this.destination + "\n"
                + "기본거리 : " + this.defaultDistance + "km\n"
                + "목적지까지 거리 : " + this.distanceToDestination + "km\n"
                + "현재 속도 : " + this.currentSpeed + "km/h\n"
                + "주유량 : " + this.gasAmount + "L\n"
                + "상태 : " + this.status + "\n";
    }
}


public class SpringAssignment1 {
    public static void main(String[] args) {
        // Bus 클래스 확인하는 부분
        Bus bus1 = new Bus(50, 1000, 50);
        System.out.println("bus1 생성 후 확인");
        System.out.println(bus1.toString());

        // 차고지행으로 상태변경 확인
        System.out.println("차고지행으로 상태변경!");
        bus1.changeStatus();
        System.out.println(bus1.toString());

        // 차고지행 상태에서 승객 태우는것 확인
        System.out.println("차고지행 상태에서 승객 20명 태우기!");
        bus1.pickUpPassenger(20);


        // 다시 운행으로 상태변경
        System.out.println("운행으로 상태변경!");
        bus1.changeStatus();
        System.out.println(bus1.toString());

        // speedUp 확인
        System.out.println("speed 20만큼 올리기!");
        bus1.speedUp(20);
        System.out.println(bus1.toString());

        // speedDown 확인
        System.out.println("speed 10만큼 내리기!");
        bus1.speedDown(10);
        System.out.println(bus1.toString());

        // pickUpPassenger 확인
        System.out.println("승객 20명씩 3번 태우기!");
        bus1.pickUpPassenger(20);
        bus1.pickUpPassenger(20);
        bus1.pickUpPassenger(20);
        System.out.println(bus1.toString());

        System.out.println("-------------");

        // bus2 생성 후 bus1과 버스번호 다른 것 확인
        Bus bus2 = new Bus(100, 1500, 70);
        System.out.println("bus2 생성 후 확인");
        System.out.println(bus2.toString());


        System.out.println("-------------");

        // 목적지와 목적지까지의 거리 정보
        HashMap<String, Integer> destinationInfo = new HashMap<>();
        destinationInfo.put("서울역", 10);
        destinationInfo.put("시청역", 4);
        destinationInfo.put("홍대", 7);


        // Taxi 클래스 확인하는 부분
        Taxi taxi1 = new Taxi(2500, 500, 5, 9);
        System.out.println("taxi1 생성 후 확인!");
        System.out.println(taxi1.toString());


        // 운행 시작 확인
        System.out.println("운행 시작!");
        taxi1.startOperation();


        // 승객 탑승 후 확인(주유량 부족)
        String destination1 = "홍대";
        int distanceToDestination1 = destinationInfo.get("홍대");
        System.out.println("홍대가는 사람 탑승!");
        taxi1.pickUpPassenger(destination1, distanceToDestination1);


        // 주유 충전 -> 주유량 증가한 것 확인
        System.out.println("주유 충전!");
        taxi1.chargeGas(10);
        System.out.println(taxi1.toString());

        // 승객 탑승 후 상태 일반 -> 운행 중 변경사항 확인
        String destination2 = "서울역";
        int distanceToDestination2 = destinationInfo.get("서울역");
        System.out.println("서울역가는 사람 탑승!");
        taxi1.pickUpPassenger(destination2, distanceToDestination2);
        System.out.println(taxi1.toString());


        // speedUp -> 현재 속도 증가한 것 확인
        System.out.println("speed 40만큼 올리기!");
        taxi1.speedUp(20);
        System.out.println(taxi1.toString());

        // speedDown 확인 -> 현재 속도 감소한 것 확인
        System.out.println("speed 10만큼 내리기!");
        taxi1.speedDown(10);
        System.out.println(taxi1.toString());


        // 총비용 확인
        System.out.println("서울역까지 비용은?");
        int totalCharge1 = taxi1.calculateTotalCharge();
        System.out.println("총 비용은" + totalCharge1 + "입니다.\n");

        // 승객 하차 후 확인
        System.out.println("서울역 도착 후 승객 하차!");
        taxi1.getOffPassenger();
        System.out.println(taxi1.toString());


        // 승객 탑승 후 확인 ( 기본 거리가 목적지까지 거리보다 더 긴 경우 )
        String destination3 = "시청역";
        int distanceToDestination3 = destinationInfo.get("시청역");
        System.out.println("서울역가는 사람 탑승!");
        taxi1.pickUpPassenger(destination3, distanceToDestination3);
        System.out.println(taxi1.toString());

        // 총비용 확인
        System.out.println("서울역까지 비용은?");
        int totalCharge2 = taxi1.calculateTotalCharge();
        System.out.println("총 비용은" + totalCharge2 + "입니다.\n");

        System.out.println("-------------");

        // taxi2 생성 후 taxi1과 택시번호 다른 것 확인
        Taxi taxi2 = new Taxi(3200, 400, 6, 20);
        System.out.println("taxi2 생성 후 확인");
        System.out.println(taxi2.toString());
    }
}
