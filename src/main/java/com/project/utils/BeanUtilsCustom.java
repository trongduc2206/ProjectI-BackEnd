package com.project.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Hoang Cuong, Nguyen Hai Long
 * @since : 2019-10-08, Tue
 **/
@Slf4j
public class BeanUtilsCustom {
    private BeanUtilsCustom() {

    }

    public static void copyNonNullProperties(Object source, Object destination) {
        BeanUtils.copyProperties(source, destination, getNullPropertyNames(source));
    }

    public static <T, E> void copyArray(List<T> source, List<E> destination, Class<E> clazz) {
        try {
            for (T t : source) {
                E temp = clazz.newInstance();
                BeanUtils.copyProperties(t, temp);
                destination.add(temp);
            }
        } catch (Exception e) {
            log.info(" Failed to init object in BeanUtilCustom.copyArray ");
        }

    }

    public static void copySpecifyProperties(Object src, Object trg, Iterable<String> props) {
        BeanWrapper srcWrap = PropertyAccessorFactory.forBeanPropertyAccess(src);
        BeanWrapper trgWrap = PropertyAccessorFactory.forBeanPropertyAccess(trg);
        props.forEach(p -> trgWrap.setPropertyValue(p, srcWrap.getPropertyValue(p)));
    }

    public static <E, D> D convertDtoType(E entity, Class<D> clazz) {
        try {
            D dto = clazz.newInstance();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (Exception e) {
            log.info("Failed to init object in BeanUltiCustom.convertToArray");
        }
        return null;
    }



    /**
     * Returns an array of null properties of an object
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set emptyNames = new HashSet();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }

}



