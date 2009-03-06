package click.controls.table;

import org.exigencecorp.util.StringBuilderr;

public abstract class AbstractColumn implements Column {

    protected Table<?> table;
    private String label;

    public Table<?> getTable() {
        return this.table;
    }

    public void setTable(Table<?> table) {
        this.table = table;
    }

    public void renderHeader(StringBuilderr sb) {
        if (this.getLabel() != null) {
            sb.append(this.getLabel());
        }
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}