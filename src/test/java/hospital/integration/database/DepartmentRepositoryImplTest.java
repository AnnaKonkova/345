package hospital.integration.database;

import hospital.domain.Department;
import hospital.repository.DepartmentRepository;
import hospital.service.DepartmentService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DepartmentRepositoryImplTest {

    @Before
    public void setup() {
        Mockito.when(_repositoryMock.getDepartmentByTitle(Mockito.any()))
                .thenReturn(new Department("someTitle"));
    }
    public DepartmentRepositoryImplTest(){
        _repositoryMock = Mockito.mock(DepartmentRepositoryImpl.class);
        _depService = new DepartmentService(_repositoryMock);
    }
    private DepartmentRepository _repositoryMock;

    private DepartmentService _depService;

    @Test
    void testAddDepartment() {
        // Arrange
        var titleToCreate = "someTitle";
        // Act

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> _depService.addDepartmentt(titleToCreate),
                "Expected addDepartmentt() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage() != null);

        // Assert
    }
}