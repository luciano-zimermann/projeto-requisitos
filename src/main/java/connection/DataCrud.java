package connection;

public interface DataCrud
{
	public void insert( Object data ) throws Exception;
	public void update( Object data ) throws Exception;
	public void delete( Object data ) throws Exception;
//	public <T> List<T> list();
}
