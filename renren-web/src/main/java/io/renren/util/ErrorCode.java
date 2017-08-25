package io.renren.util;

/**
 * 核心服务相关的错误码定义
 * 
 * @author songxiaoliang
 *
 */
public class ErrorCode {	
	public static final int SUCCESS 			= 0;			//成功
	public static final int ERROR_DEF   		= -1;			//默认失败代码
	/**
	 * 常规错误定义
	 */
	public static final int UNKNOWN_INTERNAL_ERROR = 1;					/**常规错误：系统内部错误*/
	public static final int DB_ERROR = 2;								/**常规错误：数据库操作错误*/	
	public static final int NULL_INPUT = 3;								/**常规错误：输入参数为空*/
	public static final int ILLEGAL_REQUEST = 4;						/**常规错误：非法请求，参数格式不合法*/
	public static final int CHARACTER_ENCODE = 5;						/**常规错误：字符串编码错误*/
	public static final int CHARACTER_DENCODE = 6;						/**常规错误：字符串解码错误*/
	public static final int JSON_ERROR = 7;								/**常规错误：JSON错误*/
	public static final int NULL_OUTPUT = 8;							/**常规错误：输出参数为空*/
	public static final int OTHER_ERROR = 9;							/**常规错误：其他错误*/
	public static final int CHECK_CODE_ERROR = 10;						/**常规错误：验证码错误*/

	static public final int BASE64_ENCODED_ERROR = 11;					/**Base64编码错误*/
	static public final int BASE64_DECODED_ERROR = 12;					/**Base64解码错误*/
	public static final int VALIDATOR_PARAM_ERROR = 14;					/**常规错误：请求参数格式错误*/
	public static final int FILE_NOT_FOUND = 15;						/**常规错误：找不到文件*/
	public static final int IO_ERROR = 16;								/**常规错误：IO错误*/
	public static final int HTTP_ERROR = 17;							/**常规错误：HTTP错误*/
	public static final int REPEAT_DATA = 18;							/**常规错误：重复数据*/
	
	/**
	 * 激活码相关错误定义
	 */
	public static final int ACTIVE_CODE_CREATE_ERROR = 10001;				/**创建激活码错误*/	
	public static final int ACTIVE_CODE_UPDATE_ERROR = 10002;				/**更新激活码错误*/	
	public static final int ACTIVE_CODE_DELETE_ERROR = 10003;				/**删除激活码错误*/	
	public static final int ACTIVE_CODE_INVALID = 10004;					/**激活码不正确  */
	public static final int ACTIVE_CODE_EXPIRED = 10005;					/**激活码过期   */
	public static final int ACTIVE_CODE_HASACTIVED = 10006;					/**用户已激活   */
	
	/**
	 * 邮件发送相关错误定义
	 */
	public static final int SEND_MAIL_INIT_ERROR = 20001;					/**初始化错误*/
	public static final int SEND_MAIL_SEND_ERROR = 20002;					/**邮件发送错误*/
	public static final int SEND_MAIL_INVALID_HOST = 20003;					/**服务器错误*/
	public static final int SEND_MAIL_INVALID_SENDER = 20004;				/**发送者错误*/
	public static final int SEND_MAIL_INVALID_RECEIVER = 20005;				/**接收者错误*/
	public static final int SEND_MAIL_INVALID_PASS = 20006;					/**密码错误*/
	
	/**
	 * 短消息发送相关错误定义
	 */
	public static final int SEND_SMS_IO_ERROR = 20101;						/**短消息发送错误*/
	public static final int SEND_SMS_SEND_ERROR = 20102;					/**短消息网关返回错误*/
	public static final int SEND_SMS_TIMES_OUT = 20103;						/**（单次）发送短信息次数达到上限*/
	public static final int SEND_MOBILE_ERROR = 20104;						/**发送的手机号码错误*/
	public static final int SEND_CONTENT_TOO_LONG_ERROR = 20105;			//发送的短信内容过长

	/**
	 * 用户相关错误
	 */
	public static final int USER_REGISTER_ERROR = 50000;				/**用户错误：注册错误(包括验证用户输入参数错误)*/
	public static final int USER_INVALID_USER = 50001;					/**用户错误：用户不存在*/
	public static final int USER_EXISTED = 50002;						/**用户错误：用户已存在*/
	public static final int USER_INVALID_PASSWORD = 50003;				/**用户错误：密码错误*/
	public static final int USER_INVALID_VERIFY_CODE = 50004;			/**用户错误：验证码错误*/
	public static final int USER_INVALID_QUESTION = 50005;				/**用户错误：问题错误*/
	public static final int USER_INVALID_ANSWER = 50006;				/**用户错误：问题的答案错误*/
	public static final int USER_NO_LOGIN = 50007;						/**用户错误：用户没有登录*/
	public static final int USER_LOCKED = 50008;						/**用户错误：用户已被锁定*/
	public static final int USER_NEED_REALAUTH = 50009;					/**用户错误：用户需要实名认证*/
	public static final int USER_NEED_EMAILACTIVED = 50010;				/**用户错误：用户需要EMAIL激活*/
	public static final int USER_QUESTION = 50011;						/**用户错误：用户选择的问题错误*/
	public static final int USER_ANSWER = 50013;						/**用户错误：用户用户回答的问题错误*/
	public static final int USER_NEED_MOBILEACTIVED = 50015;			/**用户错误：用户需要手机激活*/
	public static final int USER_INVALID_CODE_NULL = 50016;				/**用户错误：验证码为null*/
	public static final int USER_INVALID_EMAIL = 50017;					/**用户错误：邮箱错误*/
	public static final int USER_SESSION_EXPIRE = 50018;				/**用户错误：session过期*/
	
	/**
	 * 实名认证相关错误
	 */
	public static final int USER_REALNAME_STATUS_ERROR = 50100;					/**实名认证状态错误*/
	
	
	/**
	 * 作业系统相关错误
	 */
	public static final int JOB_NOTIFY_SEND_ERROR = 71001;			    		/**发送通知失败*/
	public static final int CACHE_NOTIFY_SEND_ERROR = 71002;			    	/**缓存更新失败*/
	public static final int SMS_CONTROL_SEND_ERROR = 71003;			    		/**缓存更新失败*/
	
	/**
	 * 系统参数相关错误
	 */
	public static final int SYSTEM_PARAMS_NOT_EXIST_ERROR = 80001;			    /**系统参数不存在*/

	/**
	 * 定时器相关错误
	 */
	public static final int TIMER_START_ERROR = 90001;			 	   /**定时器启动失败*/
	public static final int TIMER_STOP_ERROR = 90002;			 	   /**定时器停止失败*/
	public static final int TIMER_INIT_ERROR = 90003;		 		   /**定时器初始化失败*/
	public static final int TIMER_SCHEDULE_ERROR = 90011;		 	   /**定时器初始化任务失败*/
	public static final int TIMER_DELETE_ERROR = 90012;			 	   /**定时器删除任务失败*/
	public static final int TIMER_PAUSE_ERROR = 90013;		 		   /**定时器暂停任务失败*/
	public static final int TIMER_RESUME_ERROR = 90014;		 		   /**定时器恢复任务失败*/
	public static final int TIMER_TRIGGER_ERROR = 90015;			   /**定时器触发任务失败*/

}