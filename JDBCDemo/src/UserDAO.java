import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	
	Connection connection;
	
	public static UserDAO getInstance()
	{
		return new UserDAO();
	}
	
	public UserDAO()
	{
		connection=ConnectionUtil.getConnection();
	}
	
	public int saveUser(User user)
	{
		int count = 0;
		String sql="insert into user (username, mobile, email) values (?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setLong(2, user.getMobile());
			statement.setString(3, user.getEmail());
			count=statement.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int updateUser(User user)
	{
		int count=0;
		String sql="update user set username=?, mobile=?, email=? where id=?";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setLong(2, user.getMobile());
			statement.setString(3, user.getEmail());
			statement.setInt(4, user.getId());
			count=statement.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int deleteUser(int id)
	{
		int count=0;
		String sql="delete from user where id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			count=statement.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<User> allUsers()
	{
		ArrayList<User> users=new ArrayList<>();
		String sql="select * from user";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			ResultSet resultSet=statement.executeQuery();
			if(resultSet.first())
			{
				do
				{
					User user=new User();
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("username"));
					user.setMobile(resultSet.getLong("mobile"));
					user.setEmail(resultSet.getString("email"));
					users.add(user);
				}while(resultSet.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
