package on.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.err.println("args: need annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("no DBTable annotations in class" + className);
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toLowerCase(Locale.ROOT);
            }
            List<String> columns = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toLowerCase(Locale.ROOT);
                    } else {
                        columnName = sInt.name();
                    }
                    columns.add(columnName + " int" + getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1)
                        columnName = field.getName().toLowerCase(Locale.ROOT);
                    else
                        columnName = sString.name();
                    columns.add(columnName + " varchar(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }
            }
            StringBuilder createCommand = new StringBuilder(
                    "create table " + tableName + "(" );
            for (String column : columns) {
                createCommand.append("\n " + column + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + "\n);";
            System.out.println("Table Creation SQL for " + className + " is:\n" + tableCreate);
        }
    }

    private static String getConstraints(Constraints con) {
        String constrains = "";
        if (!con.allowNull()) {
            constrains = " not null ";
        }
        if (con.primaryKey()) {
            constrains += " primary key ";
        }
        if (con.unique()) {
            constrains += " unique ";
        }
        return constrains;
    }
}
