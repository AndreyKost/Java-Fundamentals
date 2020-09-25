import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        Map<String, List<String>> company=new TreeMap<>();


        while (!line.equalsIgnoreCase("end")){
            String[] tokens=line.split(" -> ");
            String companyname=tokens[0];
            String employeeId=tokens[1];

            if(company.containsKey(companyname)){
                boolean isEqual=false;
                List<String> empIds=company.get(companyname);
                for(String empid : empIds){
                    if(empid.equalsIgnoreCase(employeeId)){
                        isEqual=true;
                    }
                }
                if(!isEqual){
                    company.get(companyname).add(employeeId);
                }

            } else {
                company.put(companyname,new ArrayList<>());
                company.get(companyname).add(employeeId);
            }
            line=scanner.nextLine();
        }


        for (Map.Entry<String, List<String>> entry : company.entrySet()) {
            System.out.println(entry.getKey());
            List<String> names=entry.getValue();
            for(String name : names){
                System.out.printf("-- %s%n",name);
            }
        }


    }
}
