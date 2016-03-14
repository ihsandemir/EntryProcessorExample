import com.hazelcast.nio.serialization.DataSerializableFactory;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

/**
 * Created by sertugkaya on 09/03/16.
 */
public class EmployeeDataSerializableFactory implements DataSerializableFactory {
    static final int FACTORY_ID = 1;
    static final int EMPLOYEE_TYPE = 5;
    static final int EMPLOYEE_EP_TYPE = 6;

    @Override
    public IdentifiedDataSerializable create(int typeId) {
        if (typeId == EMPLOYEE_TYPE) {
            return new Employee();
        } else if (typeId == EMPLOYEE_EP_TYPE) {
            return new Member.EmployeeRaiseEntryProcessor();
        } else {
            return null;
        }
    }
}
