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

        // bus2 생성 후 bus1과 버스 번호 다른 것 확인
        Bus bus2 = new Bus(100, 1500, 70);
        System.out.println("bus2 생성 후 확인");
        System.out.println(bus2.toString());
    }
}
