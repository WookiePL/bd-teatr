package bd2.adminPanel.tmp;

public class Right {
	
	public static final String RIGHT_1_ID = "1";
	public static final String RIGHT_2_ID = "2";
	public static final String RIGHT_3_ID = "3";
	public static final String RIGHT_4_ID = "4";
	public static final String RIGHT_5_ID = "5";
	
	public static final String RIGHT_1_NAME = "right1";
	public static final String RIGHT_2_NAME = "right2";
	public static final String RIGHT_3_NAME = "right3";
	public static final String RIGHT_4_NAME = "right4";
	public static final String RIGHT_5_NAME = "right5";
	
	public static final String RIGHT_1_CODE = "01";
	public static final String RIGHT_2_CODE = "02";
	public static final String RIGHT_3_CODE = "03";
	public static final String RIGHT_4_CODE = "04";
	public static final String RIGHT_5_CODE = "05";
	
	private String id;
	private String name;
	private String code;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Right(String id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	@Override
	public String toString() {
		return "ID " + id + ", name " + name + ", code " + code;
	}
}
