package TestNG_groups;


    public class MessageUtil {
        private String message;

        public MessageUtil(String message) {
            this.message = message;
        }

        public String printMessage() {
            System.out.println(message);
            return message;
        }

        public String salutationMessage() {
            message = "facebook" + message;
            System.out.println(message);
            return message;
        }

        public String exitMessage() {
            message = "www." + message;
            System.out.println(message);
            return message;
        }
    }

