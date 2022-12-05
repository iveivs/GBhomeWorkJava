package Sem_3;

public class Sem_3_task_1 {
    public class MakeQuery {
        public static final String QUERY = "select * from students where ";
        public static final String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
    
        public static void main(String[] args) {
            String paramsNew = PARAMS.replace('{', ' ').replace('}', ' ');
            String[] params = paramsNew.split(",");
            StringBuilder stringBuilder = new StringBuilder(QUERY);
            for (int i = 0; i < params.length; i++) {
                String[] elements = params[i].replace('"', ' ').split(":");
                if (!"null".equals(elements[1].trim())) {
                    stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
                    if (i < params.length - 2)
                        stringBuilder.append(" and ");
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
