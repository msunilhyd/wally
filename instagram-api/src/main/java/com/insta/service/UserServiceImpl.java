package com.insta.service;

import com.insta.dto.UserDto;
import com.insta.exception.UserException;
import com.insta.model.User;
import com.insta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) throws UserException {

        Optional<User> isEmailExists = userRepository.findByEmail(user.getEmail());

        if (isEmailExists.isPresent()) {
            throw new UserException("Email already exists");
        }

        Optional<User> isUsernameExists = userRepository.findByUsername(user.getUsername());
        if(isUsernameExists.isPresent()) {
            throw new UserException("Username already exists");
        }

        if (user.getEmail() == null || user.getPassword() == null || user.getUsername() == null) {
            throw new UserException("All fields are required");
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setName(user.getName());

        return userRepository.save(newUser);
    }

    @Override
    public User findUserById(Integer userId) throws UserException {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserException("User does not exist with id: " + userId);
        }
        return user.get();
    }

    @Override
    public User findUserProfile(String token) throws UserException {
        return null;
    }

    @Override
    public User findUserByUsername(String username) throws UserException {
        return null;
    }

    @Override
    public String followUser(Integer reqUserId, Integer followUserId) throws UserException {

        User reqUser = findUserById(reqUserId);

        UserDto follower = new UserDto();
        follower.setEmail(reqUser.getEmail());
        follower.setId(reqUser.getId());
        follower.setName(reqUser.getName());
        follower.setUsername(reqUser.getUsername());
        follower.setUserImage(reqUser.getImage());

        User followUser = findUserById(followUserId);

        UserDto following = new UserDto();
        following.setEmail(followUser.getEmail());
        following.setId(followUser.getId());
        following.setName(followUser.getName());
        following.setUsername(followUser.getUsername());
        follower.setUserImage(reqUser.getImage());

        reqUser.getFollowing().add(following);
        followUser.getFollowers().add(follower);

        userRepository.save(followUser);
        userRepository.save(reqUser);

        return "You are following " + followUser.getUsername();
    }

    @Override
    public String unfollowUser(Integer reqUserId, Integer followUserId) throws UserException {
        User reqUser = findUserById(reqUserId);

        UserDto follower = new UserDto();
        follower.setEmail(reqUser.getEmail());
        follower.setId(reqUser.getId());
        follower.setName(reqUser.getName());
        follower.setUsername(reqUser.getUsername());
        follower.setUserImage(reqUser.getImage());

        User followUser = findUserById(followUserId);

        UserDto following = new UserDto();
        following.setEmail(followUser.getEmail());
        following.setId(followUser.getId());
        following.setName(followUser.getName());
        following.setUsername(followUser.getUsername());
        follower.setUserImage(reqUser.getImage());

        reqUser.getFollowing().remove(following);
        followUser.getFollowers().remove(follower);

        userRepository.save(followUser);
        userRepository.save(reqUser);

        return "You have successfully unfollowed " + followUser.getUsername();
    }

    @Override
    public List<User> findUserByIds(List<Integer> userIds) throws UserException {
        List<User> users = userRepository.findAllUsersByUserIds(userIds);
        return users;
    }

    @Override
    public List<User> searchUser(String query) throws UserException {
        List<User> users = userRepository.findByQuery(query);
        if (users.size() == 0)
            throw new UserException("user not found");
        return users;
    }

    @Override
    public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        return null;
    }
}
