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
        if(this.gasAmount < 10) {
            System.out.println("주유가 필요하다");
        }
        if(this.status == "운행"){
            this.status = "차고지행";
        } else if(this.status == "차고지행"){
            this.status = "운행";
        }
    }

    public void pickUpPassenger(int newPassenger){
        int totalPassenger = this.currentPassenger + newPassenger;
        if(totalPassenger <= maxPassenger && this.status == "운행"){
            this.currentPassenger = totalPassenger;
            //System.out.println(currentPassenger);
        } else if(totalPassenger > maxPassenger){
            System.out.println("정원 초과입니다.");
        } else if(this.status == "차고지행"){
            System.out.println("차고지행 입니다.");
        }
    }

    public void changeSpeed(int newSpeed){
        if(this.gasAmount < 10) {
            System.out.println("주유량을 확인해주세요");
        } else {
            this.currentSpeed += newSpeed;
            //System.out.println(this.currentSpeed);
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
        Bus bus1 = new Bus(50, 1000, 50);
        System.out.println(bus1.toString());

        // 차고지행으로 상태변경
        bus1.changeStatus();
        System.out.println(bus1.toString());

        // 차고지행 상태로 승객 20명 태우기
        bus1.pickUpPassenger(20);
        System.out.println(bus1.toString());

        // 다시 운행으로 상태변경
        bus1.changeStatus();
        System.out.println(bus1.toString());

        // 승객 20명씩 3번 태우기
        bus1.pickUpPassenger(20);
        bus1.pickUpPassenger(20);
        bus1.pickUpPassenger(20);
        System.out.println(bus1.toString());

        // speed를 20으로 올리기
        bus1.changeSpeed(20);
        System.out.println(bus1.toString());

        // speed를 10만큼 내리기
        bus1.changeSpeed(-10);
        System.out.println(bus1.toString());

        System.out.println("-------------");

        // bus2 생성 후 bus1과 버스 번호 다른 것 확인
        Bus bus2 = new Bus(100, 1500, 70);
        System.out.println(bus2.toString());
    }
}
