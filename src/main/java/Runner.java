public class Runner {

    private static final int COUNT = 10;

    Template template;

    public Runner(Template template) {
        this.template = template;
    }

    public long run() {
        long totalTime = 0;
        for (int i = 0; i < COUNT; i++) {
            long time = template.run();
            System.out.println(time);
            totalTime += time;
        }
        return totalTime/COUNT;
    }
}
