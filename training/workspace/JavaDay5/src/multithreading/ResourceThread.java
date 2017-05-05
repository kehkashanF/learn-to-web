package multithreading;

public class ResourceThread extends Thread{
		private Resource resource;
		private String msg;
		public ResourceThread(Resource resource, String msg) {
			this.resource = resource;
			this.msg = msg;
			start();
		}
		@Override
		public void run() {
			resource.PrintMsg(msg);
		}
		
		
}
