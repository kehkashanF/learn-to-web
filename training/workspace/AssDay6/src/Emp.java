import java.util.Date;


public class Emp {
		private int id;
		private String name;
		private String job;
		private Date joinDate;
		
		
		public Emp(int id, String name, String job, Date joinDate) {
			super();
			this.id = id;
			this.name = name;
			this.job = job;
			this.joinDate = joinDate;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public Date getJoinDate() {
			return joinDate;
		}
		public void setJoinDate(Date joinDate) {
			this.joinDate = joinDate;
		}
		@Override
		public String toString() {
			return "Emp [id=" + id + ", name=" + name + ", job=" + job
					+ ", joinDate=" + joinDate + "]";
		}
		
		
}
