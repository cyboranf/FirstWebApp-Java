import entity.User;
import entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;





@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();

        HashMap<Integer, User> studentMap = UserDao.create(request);

        request.setAttribute("studentMap", studentMap);
        request.setAttribute("listAction", "no");

        getServletContext().getRequestDispatcher("/StudentList").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        request.setAttribute("listAction", "add");

        getServletContext().getRequestDispatcher("/StudentList").forward(request, response);





//		HashMap<Integer, Group> groupMap = (HashMap<Integer, Group>) sess.getAttribute("groupMap");
//		ArrayList<Group> groupList = new ArrayList<Group>();
//
//		Set<Integer> mySet = groupMap.keySet();
//		for (Integer key : mySet) { // iteracja po elementach hashMapy
//			groupList.add(groupMap.get(key));
//		}
//
//		request.setAttribute("myAttrMap", groupMap);
//		request.setAttribute("myAttribute", groupList);
//
//		getServletContext().getRequestDispatcher("/groupMain.jsp").forward(request, response);
    }

}
