package io.datajek.unittesting;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentService {
    
    private StudentDao studentDao;

    int findTotal(){
        int[] array = studentDao.getMarks();
        int sum = 0;
        for(int value: array){
            sum += value;
        }
        return sum;
      
    }
}
