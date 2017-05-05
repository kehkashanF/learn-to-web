
public class Employee {
			private int id;
			private String name;
			private int deptId;
			private int mgrId;
			private String job;
			
			
//			public Employee(int id, String name, int deptId, int mgrId, String job) {
//				super();
//				this.id = id;
//				this.name = name;
//				this.deptId=deptId;
//				this.mgrId = mgrId;
//				this.job = job;
//			}
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
			public int getMgrId() {
				return mgrId;
			}
			public void setMgrId(int mgrId) {
				this.mgrId = mgrId;
			}
			public String getJob() {
				return job;
			}
			public void setJob(String job) {
				this.job = job;
			}
			public int getDeptId() {
				return deptId;
			}
			public void setDeptId(int deptId) {
				this.deptId = deptId;
			}
			@Override
			public String toString() {
				return "Employee [id=" + id + ", name=" + name + ", deptId="
						+ deptId + ", mgrId=" + mgrId + ", job=" + job + "]";
			}
			
			 
			
			
}
