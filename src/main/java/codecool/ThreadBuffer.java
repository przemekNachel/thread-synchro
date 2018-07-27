package codecool;

class ThreadBuffer {

    public String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static void main(String[] args) {
        new ThreadBuffer().dos();
    }

    private void dos() {
        Buffer buffer1 = new Buffer(1, this);
        buffer1.start();
        Buffer buffer2 = new Buffer(2, this);
        buffer2.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer1.interrupt();
        buffer2.interrupt();
        System.out.println(string + " koncowy");
    }

    synchronized void jedyneczka() {
        notify();
        setString("jedyneczka");
        try {
            wait();
        } catch (InterruptedException e) {
            return;
        }
    }

    synchronized void dwojeczka() {
        notify();
        setString("dwojeczka");
        try {
            wait();
        } catch (InterruptedException e) {
            return;
        }
    }
}

