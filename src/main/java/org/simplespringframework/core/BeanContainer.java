package org.simplespringframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simplespringframework.core.annatation.Component;
import org.simplespringframework.core.annatation.Controller;
import org.simplespringframework.core.annatation.Repository;
import org.simplespringframework.core.annatation.Service;
import org.simplespringframework.util.ClassUtil;
import org.simplespringframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 存放所有被配置标记的目标对象的Map
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 加载bean的注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Component.class, Controller.class, Repository.class, Service.class);


    /**
     * 获取Bean容器实例
     *
     * @return BeanContainer
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 容器是否已加载过bean
     */
    private boolean loaded = false;

    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 扫描加载所有bean
     *
     * @param packageName 包名
     */
    public synchronized void loadBean(String packageName) {
        // 判断bean容器是否被加载过
        if (isLoaded()) {
            log.warn("BeanContainer has bean loaded.");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from {}", packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                if (clazz.isAnnotationPresent(annotation)) {
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

}
