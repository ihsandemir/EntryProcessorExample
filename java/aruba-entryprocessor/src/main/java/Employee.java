/**
 * Created by sertugkaya on 09/03/16.
 */
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

import java.io.IOException;

public class Employee implements IdentifiedDataSerializable {

    private Integer s;

    public Employee(Integer s) {
        this.s = s;
    }

    public Employee() {
    }

    @Override
    public int getFactoryId() {
        return EmployeeDataSerializableFactory.FACTORY_ID;
    }

    @Override
    public int getId() {
        return EmployeeDataSerializableFactory.EMPLOYEE_TYPE;
    }

    @Override
    public void writeData(ObjectDataOutput objectDataOutput)
            throws IOException {
        objectDataOutput.writeInt(s);

    }

    @Override
    public void readData(ObjectDataInput objectDataInput)
            throws IOException {
        this.s = objectDataInput.readInt();

    }

    public int getSalary() {
        return s;
    }

    public void incSalary(int delta) {
        s += delta;
    }
}

