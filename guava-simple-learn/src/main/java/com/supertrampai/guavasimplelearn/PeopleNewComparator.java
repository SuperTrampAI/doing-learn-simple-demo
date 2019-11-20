package com.supertrampai.guavasimplelearn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description: 综合排序，在重写的方法中定义
 * @Date: Created in 13:36 2019/11/20
 * @Modified By:
 */
public class PeopleNewComparator implements Comparator<PeopleNew> {

    public static void main(String[] args) {
        List< PeopleNew > peopleNews = new ArrayList< PeopleNew >();
        peopleNews.add( new PeopleNew( 10, "a" ) );
        peopleNews.add( new PeopleNew( 11, "d" ) );
        peopleNews.add( new PeopleNew( 15, "s" ) );
        peopleNews.add( new PeopleNew( 6, "x" ) );
        peopleNews.add( new PeopleNew( 17, "a" ) );
        peopleNews.add( new PeopleNew( 17, "b" ) );
        peopleNews.add( new PeopleNew( 17, "c" ) );
        peopleNews.add( new PeopleNew( 17, "d" ) );
        PeopleNewComparator comparator = new PeopleNewComparator();

        peopleNews.sort( comparator );
        // 也可以使用：Collections.sort( users, comparator );

        for ( PeopleNew peopleNew : peopleNews ) {
            System.out.println( peopleNew );
        }
    }
    @Override
    public int compare(PeopleNew o1, PeopleNew o2) {
        if ( o1.equals( o2 ) ) {
            return 0;
        }
        else if ( o1.getAge() < o2.getAge() ) {
            return 1;
        }
        else if ( o1.getAge() == o2.getAge() ) {
            int f = o1.getName().compareTo( o2.getName() );
            if ( f < 0 ) {
                return -1;
            }
            return 0;
        }
        else {
            return -1;
        }
    }
}
