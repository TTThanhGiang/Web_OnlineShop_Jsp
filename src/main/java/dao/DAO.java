package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.SQLSEVERDataAccess;
import entity.category;
import entity.product;
import context.*;


public class DAO {
    public List<product> getAllProduct() {
        List<product> list = new ArrayList<>();
        try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet("select * from tbSANPHAM order by cast(SUBSTRING(MASANPHAM,3,LEN(MASANPHAM))as int)");
			while(rs.next()) {
				list.add(new product(rs.getString(1), 
						rs.getString(2), 
						rs.getDouble(3),
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
        return list;
    }
    
    public static void main(String[] args) {
		DAO dao = new DAO();
		List<product> list = dao.getAllProduct();
		for (product product : list) {
			System.out.println(product.getName());
		}
		
	}
	public product getProductByTd(String id) {
		String SQL = "select * from tbSANPHAM where MASANPHAM='" + id + "'";
        try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet(SQL);
			while(rs.next()) {
				return new product(rs.getString(1), 
						rs.getString(2), 
						rs.getDouble(3),
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public category getCatoryByTd(String id) {
		String SQL = "select tbDANHMUC.MADANHMUC , TENDANHMUC \r\n"
				+ "from tbDANHMUC \r\n"
				+ "join tbSANPHAM on tbDANHMUC.MADANHMUC = tbSANPHAM.MADANHMUC\r\n"
				+ "where MASANPHAM= '" + id+ "'";
        try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet(SQL);
			while(rs.next()) {
				return new category(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;
	}
	public List<category> ListDanhMuc() {
		List<category> listDm = new ArrayList<category>();
		String SQL = "select * from tbDANHMUC";
		try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet(SQL);
			while(rs.next()) {
				listDm.add(new category(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listDm;
	}
	public List<product> ListSanPhamDM(String madanhmuc) {
		List<product> listSPDM = new ArrayList<product>();
		String SQL = "select *"
				+ "from tbSANPHAM \r\n"
				+ "where MADANHMUC= '" + madanhmuc+ "'";
		try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet(SQL);
			while(rs.next()) {
				listSPDM.add(new product(rs.getString(1), 
						rs.getString(2), 
						rs.getDouble(3),
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSPDM;
	}
	public int DeleteProduct(String productId) {
		String SQL = "delete from tbSANPHAM where MASANPHAM = '"+ productId + "'";
		int k = 1;		
		try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
        	k = con.ExecuteSQL(SQL);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public int UpdateProduct(product product) {
		String SQL= null;
		int k = 0;
		if(product.getImages()!= null) {
			SQL= "update tbSANPHAM set TENSANPHAM ='"+product.getName()+"', "
					+ "DONGIA='"+product.getPrice()+"', "
					+ "SOLUONG='"+product.getQuantity()+"', "
					+ "HINHANH='"+product.getImages()+"', "
					+ "DONGIA='"+product.getDescription();
		}else {
			SQL="update tbSANPHAM set TENSANPHAM ='"+product.getName()+"', "
					+ "DONGIA='"+product.getPrice()+"', "
					+ "SOLUONG='"+product.getQuantity()+"', "
					+ "DONGIA='"+product.getDescription();
		}
		try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
        	k = con.ExecuteSQL(SQL);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return k;
	}
	public category getCategoryByTd(String id) {
		String SQL = "select tbDANHMUC.MADANHMUC , TENDANHMUC \r\n"
				+ "from tbDANHMUC \r\n"
				+ "join tbSANPHAM on tbDANHMUC.MADANHMUC = tbSANPHAM.MADANHMUC\r\n"
				+ "where MASANPHAM= '" + id+ "'";
        try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet(SQL);
			while(rs.next()) {
				return new category(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
    public List<product> getProducts(int start, int total, String categoryID) {
        List<product> list = new ArrayList<>();
        try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet("select * from tbSANPHAM"
					+ " where MADANHMUC LIKE '%" + categoryID + "%'"
					+ " order by cast(SUBSTRING(MASANPHAM,3,LEN(MASANPHAM))as int)"
					+ " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;", new Object[] {start-1, total});
			while(rs.next()) {
				list.add(new product(rs.getString(1), 
						rs.getString(2), 
						rs.getDouble(3),
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }
    
    public int getTotalPage(int pageSize, String categoryID) {
    	int totalPage = 1;
    	try {
    		SQLSEVERDataAccess con = new SQLSEVERDataAccess();
    		ResultSet rs = con.getResultSet("SELECT COUNT(MASANPHAM) FROM tbSANPHAM WHERE MADANHMUC LIKE '%" + categoryID + "%'");
    		rs.next();
    		int count = rs.getInt(1);
    		totalPage = ((count-1) / pageSize) + 1;
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return totalPage;
    }
    
    public List<category> getCategories() {
    	List<category> list = new ArrayList<>();
    	list.add(new category("", "Tất cả", getTotalProduct()));
        try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet("SELECT tbDANHMUC.MADANHMUC, TENDANHMUC, COUNT(MASANPHAM)"
					+ " FROM tbDANHMUC, tbSANPHAM"
					+ " where tbDANHMUC.MADANHMUC = tbSANPHAM.MADANHMUC"
					+ " GROUP BY tbDANHMUC.MADANHMUC, TENDANHMUC");
			while(rs.next()) {
				list.add(new category(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }
    
    public int getTotalProduct() {
    	int count = 0;
    	try {
        	SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			ResultSet rs = con.getResultSet("SELECT COUNT(MASANPHAM) FROM tbSANPHAM");
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return count;
    }
}
