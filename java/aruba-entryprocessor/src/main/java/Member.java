import com.hazelcast.core.Hazelcast;
import com.hazelcast.map.AbstractEntryProcessor;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sertugkaya on 09/03/16.
 */
public class Member {
    public static void main(String[] args) {
        Hazelcast.newHazelcastInstance();
    }

    public static class EmployeeRaiseEntryProcessor
            extends AbstractEntryProcessor<String, Employee>
            implements IdentifiedDataSerializable {
        @Override
        public Object process(Map.Entry<String, Employee> entry) {
            Employee value = entry.getValue();
            value.incSalary(10);
            entry.setValue(value);
            return null;
        }

        @Override
        public int getFactoryId() {
            return EmployeeDataSerializableFactory.FACTORY_ID;
        }

        @Override
        public int getId() {
            return EmployeeDataSerializableFactory.EMPLOYEE_EP_TYPE;
        }

        @Override
        public void writeData(ObjectDataOutput objectDataOutput)
                throws IOException {

        }

        @Override
        public void readData(ObjectDataInput objectDataInput)
                throws IOException {

        }
    }
}
