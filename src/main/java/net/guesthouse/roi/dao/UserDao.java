package net.guesthouse.roi.dao;

import net.guesthouse.roi.dto.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	private static final String namespace = "net.guesthouse.roi.UserModel.";
	@Autowired
	private CommonDAO commonDao;

	// crud

	public void insertUser(UserModel userModel) {
		commonDao.insert(namespace + "insertUser", userModel);
	}

	public UserModel selectUser(UserModel userModel) {
		return commonDao.selectOne(namespace + "selectUser", userModel);
	}

	public int updateUser(UserModel userModel) {
		return commonDao.update(namespace + "updateUser", userModel);
	}

	public int deleteUser(UserModel userModel) {
		return commonDao.delete(namespace + "deleteUser", userModel);
	}
}
