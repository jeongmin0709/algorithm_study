public class Main {
    public static void main(String[] args) {
        String[][] maps = {{"05:57", "06:02"}, {"04:00", "06:59"}, {"03:56", "07:57"}, {"06:12", "08:55"}, {"07:09", "07:11"}};
        Hotel hotel = new Hotel();
        int solution = hotel.solution(maps);
        System.out.println(solution);
    }
}
