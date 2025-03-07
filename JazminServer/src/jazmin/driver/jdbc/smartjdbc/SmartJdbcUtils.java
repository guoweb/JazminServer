package jazmin.driver.jdbc.smartjdbc;

import jazmin.driver.jdbc.smartjdbc.enums.DatabaseType;

/**
 * 
 * @author skydu
 *
 */
public class SmartJdbcUtils {

	/**
	 * 
	 * @param type
	 */
	public static boolean isBasePostgresql(DatabaseType type) {
		if (type.equals(DatabaseType.POSTGRESQL)||
				type.equals(DatabaseType.KINGBASE)||
				type.equals(DatabaseType.NDS)
				) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public static String identifier(DatabaseType type) {
		if(DatabaseType.MYSQL.equals(type)) {
			return "`";
		} else if(isBasePostgresql(type)) {
			return "\"";
		} 
		// sql server use [field] or "field"
		else if (DatabaseType.SQLSERVER.equals(type)) {
			return "\"";
		}
		return "";
	}

	/**
	 *  leftIdentifier
	 * @param type
	 * @return
	 */
	public static String leftIdentifier(DatabaseType type) {
		if(DatabaseType.MYSQL.equals(type)) {
			return "`";
		} else if(isBasePostgresql(type)) {
			return "\"";
		}
		// sql server use [field] or "field"
		else if (DatabaseType.SQLSERVER.equals(type)) {
			return "[";
		}
		return "";
	}

	/**
	 *  leftIdentifier
	 * @param type
	 * @return
	 */
	public static String rightIdentifier(DatabaseType type) {
		if(DatabaseType.MYSQL.equals(type)) {
			return "`";
		} else if(isBasePostgresql(type)) {
			return "\"";
		}
		// sql server use [field] or "field"
		else if (DatabaseType.SQLSERVER.equals(type)) {
			return "]";
		}
		return "";
	}
	
	public static String addIdentifier(DatabaseType type, String fieldName) {
		return leftIdentifier(type) + fieldName + rightIdentifier(type);
	}
}
