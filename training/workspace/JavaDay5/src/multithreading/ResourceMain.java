package multithreading;

public class ResourceMain {
		public static void main(String[] args) {
			Resource resource = new Resource();
			new ResourceThread(resource, "Hello");
			new ResourceThread(resource, "Welcome");
			new ResourceThread(resource, "Java");
		}
}
