package com.kzheng.design_pattern.strategic;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/1 20:27
 */
public class OperatorFactory {

    private static Map<String, Operation> operationMap = new HashMap<>();

    static {
        //初始化实现类
        operationMap.put("add", new AddOperation());
        operationMap.put("sub", new SubOperation());
        operationMap.put("multi", new MultiOperation());
        operationMap.put("div", new DivOperation());
        // more operators
    }

    /**
     * 获取对应的目标实现类
     * @param operator
     * @return
     */
    public static Optional<Operation> getOperation(String operator){
        return Optional.ofNullable(operationMap.get(operator));
    }
    public static void main(String[] args) {
        //获取计算的目标实现类
        Operation targetOperation = OperatorFactory
                .getOperation("add")
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        int result = targetOperation.execute(1, 2);
        System.out.println("result:" +  result);
    }


}