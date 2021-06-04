package Utils;

import Model.DataAndOrderModel;

import java.util.Scanner;

/**
 * Created by srikar on 04-06-2021.
 */

public class GenerateDataUtil {
    public static DataAndOrderModel getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the order in which the sorting should be done (ASC or DESC): ");
        String order  = sc.nextLine();
        System.out.println("Size of array to sort: ");
        int n = sc.nextInt();
        int[] data = new int[n];
        System.out.println("Enter numbers to sort: ");
        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }
        return new DataAndOrderModel(data, order);
    }
}
