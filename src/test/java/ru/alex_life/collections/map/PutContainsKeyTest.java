package ru.alex_life.collections.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import ru.alex_life.collections.map.PutContainsKey.User;

import java.util.List;
import java.util.Map;

/**
 *  Упражнения.
 *  Вставка новых элементов в Map
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.07.2022
 */
public class PutContainsKeyTest {
    @Test
    public void addNewElement() {
        User one = new User(1, "Name1");
        User two = new User(2, "Name2");
        User three = new User(1, "Name3");
        List<User> list = List.of(one, two, three);
        Map<Integer, User> map = PutContainsKey.addNewElementWithCheck(list);
        Map<Integer, User> expected = Map.of(1, one, 2, two);
        assertThat(map, is(expected));
    }

    @Test
    public void addNewElementWithoutCheck() {
        User one = new User(1, "Name1");
        User two = new User(2, "Name2");
        User three = new User(1, "Name3");
        List<User> list = List.of(one, two, three);
        Map<Integer, User> map = PutContainsKey.addNewElementWithoutCheck(list);
        Map<Integer, User> expected = Map.of(1, three, 2, two);
        assertThat(map, is(expected));
    }
}
