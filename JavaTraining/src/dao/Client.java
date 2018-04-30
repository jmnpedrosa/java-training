package dao;

import java.util.ArrayList;
import java.util.Collection;

/* 
 * The DAO pattern abstracts and encapsulates all access to a data store (flat files, relational
 * databases, XML, JSON, or any other data source). It manages the connection
 * with the data source to access and store the data. It shields a client from knowing how
 * to retrieve or store data and lets it specify what data to retrieve and store. So it makes
 * the client code flexible to work with multiple data sources.
 */

class Item {
  int id;
  String name;
  int version;
  String uri;
}

interface ItemDAO {
  public int create(Item e);
  public Item get(int id);
  public boolean delete(Item e);
  public boolean update(Item e);
  public Collection<Item> getAll();
}

class DefaultItemDAO implements ItemDAO {
  public int create(Item e) {
    /* connect to datastore, insert data for item e */
    return 0;
  }
  public Item get(int id) {
    /* connect to datastore, retrieve and return data for item id */
    return new Item();
  }
  public boolean delete(Item e) {
    /* connect to datastore and delete data for item e.id */
    return true;
  }
  public boolean update(Item e) {
    /* connect to datastore and update item data */
    return true;
  }
  public Collection<Item> getAll() {
    /* connect to datastore, retrieve item data, return as Collection */
    return new ArrayList<Item>();
  }
}

public class Client {
  public static void main(String args[]) {
    Item item = new Item();
    item.id = 1; 
    item.name = "my-fancy-item";
    item.version = 1; 
    item.uri = "http://my-fancy-item.somerepo.pt";
    
    ItemDAO dao = new DefaultItemDAO();
    dao.create(item);
    
    item.name = "my-little-item";
    item.version = 2;
    
    dao.update(item);
    
    Item item2 = dao.get(11);
    
    if (item2 != null) 
      dao.delete(item2);
  }
}
