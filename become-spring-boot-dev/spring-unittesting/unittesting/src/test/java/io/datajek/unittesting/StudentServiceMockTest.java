package io.datajek.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceMockTest {

    @Mock
    StudentDao studentDaoMock;

    @InjectMocks
    StudentService studentService;

    @Test
    void testFindTotal() {
        when(studentDaoMock.getMarks()).thenReturn(new int[] { 50, 60, 70 });

        int total = studentService.findTotal();
        assertEquals(180, total);
    }

    @Test
    void testFindTotal_EmptyArray() {
        when(studentDaoMock.getMarks()).thenReturn(new int[] {});

        int total = studentService.findTotal();
        assertEquals(0, total);
    }

}
