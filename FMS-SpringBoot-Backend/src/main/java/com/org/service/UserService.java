package com.org.service;

@Service
public class UserService{
	
	@Autowired
	UserDao dao;
	
		/*
		 * Adding New User
		 */
		public void createUser(User newUser) {
		
		Optional<User> findUserById = dao.findById(newUser.getUserId());
		if(!findUserById.isPresent())
			dao.save(newUser);
		else
			throw new RecordAlreadyPresentException("User with details: "+ newUser.getUserId() +" already exists!!");
		}
		
		/*
		 * View all Users
		 */
		public Iterable<User> viewAllUser(){
			return dao.findAll();
		}
		/*
		 * Searching User By Id
		 */
		public User viewUser(Biginteger userId) {
			Optional<User> findById=UserDao.findById(userId);
			return findById.get();
		}
		
		/*
		 * Delete User
		 */
		public void deleteUser(BigInteger userId) {
			
			Optional<User> findUserById = dao.findById(userId);
			if(findUserById.isPresent())
				dao.deleteById(UserId);
			else
				throw new RecordNotFoundException("User with  Id: "+ userId +" not exists!!");
		}
		/*
		 * Update User
		 */
		public void updateUser(User updateUser) {
			
			Optional<User> findUserById = dao.findById(updateUser.getUserId());
			if(findUserById.isPresent())
				dao.save(updateUser);
			else
				throw new RecordNotFoundException("User with Id: "+ updateUser.getUserId() +" not exists!!");
			
		}
}