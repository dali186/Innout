import java.util.Scanner;

public class Innout {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. 입금
                    2. 출금
                    3. 조회
                    4. 종료
                    """);
            int select = sc.nextInt();
            int content = 0;

            switch (select) {
                case 1 :
                    System.out.println("입금하실 금액을 입력해주세요.");
                    content = sc.nextInt();
                    Service.Deposit(content);
                    break;
                case 2:
                    System.out.println("출금하실 금액을 입력해주세요.");
                    content = sc.nextInt();
                    Service.Withdraw(content);
                    break;
                case 3 :
                    System.out.println("조회내역");
                    Service.Check();
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    break;
                default:
                    System.out.println("지정된 숫자만 입력해주세요.");
                    continue;
            }

            if(select == 4) break;  //종료
        }
    }
}
