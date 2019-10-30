class ProjectTest {
    public static void main(String[] args) {
        Project a = new Project();
        String inf = a.info("Project1", "In Progress");
        System.out.println(inf);

        Project b = new Project();
        b.setName("Project2");
        b.setDesc("Done");
        String project2_name = b.getName();
        String project2_desc = b.getDesc();
    
        System.out.println(project2_name + " : " + project2_desc);
    }
}