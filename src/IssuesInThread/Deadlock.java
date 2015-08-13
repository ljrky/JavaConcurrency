package IssuesInThread;

public class Deadlock {
    static class Friend{

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower){
            System.out.format("%s, %s" + " has bowed to me! %n", this.name, bower.getName());
            bower.bowBasck(this);
        }

        public synchronized void bowBasck(Friend bower){
            System.out.format("%s, %s" + " has bowed back to me %n", this.name, bower.getName());
        }
    }




    public static void main(String[] args) {
        System.out.println("This is deadlock sample");

        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();


    }

}