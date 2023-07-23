package com.onlinefoodorder.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlinefoodorder.pojo.Menu;
import com.onlinefoodorder.pojo.User;
import org.hibernate.query.Query;

@Component
public class MenuDAO extends DAO {

	public void addItem(Menu menu) {
		try {
			begin();
			getSession().save(menu);
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
	}

	public List<Menu> displayAllMenuByRestaurantId(int userId) {

		List<Menu> menuList = null;
		try {
			begin();
			Query query = getSession().createQuery("from Menu where UserId=:userid");
			query.setParameter("userid", userId);
			menuList = query.list();
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
		return menuList;
	}

	public Menu getMenuObjById(int menuId) {

		Menu menu = null;
		try {

			menu = getSession().get(Menu.class, menuId);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
		return menu;
	}

	public void updateMenuItem(Menu menuItem) {
		try {
			begin();
			getSession().update(menuItem);
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
	}

//	public void deleteMenu(int menuid) {
//		try {
//			begin();
//			getSession().delete(getSession().get(Menu.class, menuid));
//			commit();
//		}
//		catch (Exception e) {
//			System.out.println("Exception: " + e.getMessage());
//		} finally {
//			close();
//		}
//
//	}
	
	public void deleteMenu(int menuid){
        try {
            //delete item object in the database
            begin();
            String hql = "delete from Menu where menuid = :delId";
            Query query = getSession().createQuery(hql);
            query.setParameter("delId", menuid);
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            commit();

        } catch (Exception e) {
            rollback();

            System.out.println("Exception: " + e.getMessage());
        }finally {
            close();
        }
    }
}
