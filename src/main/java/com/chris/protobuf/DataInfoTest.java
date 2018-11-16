package com.chris.protobuf;

import java.util.Arrays;

public class DataInfoTest {
    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("Chris")
                .setAge(18)
                .setAddress("合肥")
                .build();

        byte[] studentToByteArray = student.toByteArray();
        Arrays.asList(studentToByteArray).forEach(System.out::println);

        DataInfo.Student student2 = DataInfo.Student.parseFrom(studentToByteArray);

        System.out.println(student2);
    }
}
