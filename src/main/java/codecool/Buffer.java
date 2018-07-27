package codecool;

class Buffer extends Thread{

    private int state;
    private ThreadBuffer threadBuffer;

    public Buffer(int state, ThreadBuffer threadBuffer) {
        this.state = state;
        this.threadBuffer = threadBuffer;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            if (state == 1) threadBuffer.jedyneczka();
            else threadBuffer.dwojeczka();
            System.out.println(threadBuffer.getString());
        }
    }




}
