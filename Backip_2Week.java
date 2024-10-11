import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Backip_2Week {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String type = sc.nextLine();
        String title = sc.nextLine();
        ArrayList<String> cookLines = new ArrayList<String>();
        LinkedHashSet<String> cookSets = new LinkedHashSet<String>();
        Map<String, String> cookMap = new HashMap<String, String>();

        String flag = "";
        int i = 1;
        while(true) {
            String text = sc.nextLine();
            if (text.equals("끝")) {
                break;
            }else{
                switch (type) {
                    case "List" -> cookLines.add(text);
                    case "Set" -> cookSets.add(text);
                    case "Map" -> cookMap.put(i + ".", text);
                }
            }
            i++;
        }

        System.out.println("[ "+type+" 으로 저장된 "+title+" ]");

        switch (type) {
            case "List" -> {
                for(int j=0; j<cookLines.size(); j++) {
                    System.out.println((j+1)+". "+ cookLines.get(j));
                }
            }
            case "Set" -> {
                Iterator<String> ite = cookSets.iterator();
                for(int j=0; j<cookSets.size(); j++) {
                    System.out.println((j+1)+". "+ ite.next());
                }

            }
            case "Map" -> {
                for(int j=0; j<cookMap.size(); j++) {
                    System.out.println((j+1)+". "+ cookMap.get(j));
                }
            }
        }

    }
}