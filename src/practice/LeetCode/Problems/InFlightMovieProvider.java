package practice.LeetCode.Problems;

import java.util.*;

/**
 * Created by srikar on 05-06-2021.
 */

/**
 * You are a in-flight movie service provider. You are given a list of movie lengths and the duration of the flight.
 * Return a pair of (2) movies whose combined length is the highest and is less than or equal to flight duration.
 * If multiple such combinations are possible, return the pair which has the movie of longer longest duration.
 *
 * Ex : MovieLenghts : {27, 1,10, 39, 12, 52, 32, 67, 76}
 * Flight Duration : 77.
 * The 2 possible pairs are (1,76) and (10,67), The answer is (1,76) as per the last constraint.
 */

public class InFlightMovieProvider {

    public static void main(String[] args) {
        int[] movieLengths = {27, 1, 10, 39, 12, 52, 32, 67, 67, 76};
        int[] movieLengths2 = {90, 85, 75, 60, 120, 150, 125};
        int[] movieLengths3 = {90, 85, 75, 60, 120, 110, 110, 150, 125};
        int duration = 77;
        int duration2 = 250;
        System.out.println(Arrays.toString(possiblePairOfMoviesToWatch(movieLengths, duration)));
        System.out.println(Arrays.toString(possiblePairOfMoviesToWatch(movieLengths2, duration2)));
        System.out.println(Arrays.toString(possiblePairOfMoviesToWatch(movieLengths3, duration2)));

    }

    public static int[] possiblePairOfMoviesToWatch(int[] array, int duration) {
        Arrays.sort(array);
        int[] pair = new int[]{-1, -1};
        int max = 0;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int sum = array[start] + array[end];
            if ((sum > max || max == sum && Math.max(array[start], array[end]) > Math.max(pair[0], pair[1])) && sum <= duration) {
                max = sum;
                pair[0] = array[start];
                pair[1] = array[end];
            }
            if (sum > duration) {
                end--;
            } else {
                start++;
            }
        }
        return pair;
    }

// Another approach to return the indices pair
    private static int[] get2SumClosest(int[] movie_duration, int d) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<movie_duration.length;i++) {
            map.putIfAbsent(movie_duration[i], new ArrayList<>());
            map.get(movie_duration[i]).add(i);
        }
        Arrays.sort(movie_duration);
        int l = 0, r = movie_duration.length - 1;
        int max = 0;
        int[] res = new int[]{-1, -1};
        while(l < r) {
            int sum = movie_duration[l] + movie_duration[r];
            if((sum > max || (sum == max && Math.max(movie_duration[l] , movie_duration[r]) > Math.max(res[0],  res[1]))) && sum <= d) {
                max = sum;
                res[0] = movie_duration[l];
                res[1] = movie_duration[r];
            }
            if(sum > d)
                r--;
            else
                l++;
        }
        if(map.get(res[0]) == map.get(res[1])) {
            res[0] = map.get(res[0]).get(0);
            res[1] = map.get(res[1]).get(1);
        }else {
            res[0] = map.get(res[0]).get(0);
            res[1] = map.get(res[1]).get(0);
        }
        return res;
    }

}

