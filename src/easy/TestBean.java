package easy;

import java.util.List;

/**
 * @auth: sarWang
 * @date: 2019-08-01 16:46
 * @describe
 */
public class TestBean {


    /**
     * code : 200
     * data : [{"createTime":1559285258000,"deleted":false,"enabled":true,"id":41,"list":[{"createTime":1559293018000,"deleted":false,"enabled":true,"id":50,"list":[],"name":"台式电脑","path":"办公电脑,台式电脑","pathId":"41,50","pid":41,"sort":103,"updateTime":1560495692000,"version":5},{"createTime":1559285265000,"deleted":false,"enabled":true,"id":42,"list":[],"name":"笔记本","path":"办公电脑,笔记本","pathId":"41,42","pid":41,"sort":101,"updateTime":1560495650000,"version":3},{"createTime":1560824945000,"deleted":false,"enabled":true,"id":62,"list":[],"name":"一体机","path":"办公电脑,一体机","pathId":"41,62","pid":41,"sort":100,"updateTime":1560824945000,"version":1},{"createTime":1560824956000,"deleted":false,"enabled":true,"id":63,"list":[],"name":"单主机","path":"办公电脑,单主机","pathId":"41,63","pid":41,"sort":100,"updateTime":1560824955000,"version":1},{"createTime":1560824965000,"deleted":false,"enabled":true,"id":64,"list":[],"name":"显示器","path":"办公电脑,显示器","pathId":"41,64","pid":41,"sort":100,"updateTime":1560824964000,"version":1}],"name":"办公电脑","path":"办公电脑","pathId":"41","pid":0,"sort":100,"updateTime":1559293005000,"version":2},{"createTime":1559615846000,"deleted":false,"enabled":true,"id":58,"list":[{"createTime":1559615855000,"deleted":false,"enabled":true,"id":59,"list":[],"name":"打印机","path":"办公设备,打印机","pathId":"58,59","pid":58,"sort":100,"updateTime":1560824988000,"version":2},{"createTime":1559615862000,"deleted":false,"enabled":true,"id":60,"list":[],"name":"投影仪","path":"办公设备,投影仪","pathId":"58,60","pid":58,"sort":100,"updateTime":1560825002000,"version":3},{"createTime":1559615878000,"deleted":false,"enabled":true,"id":61,"list":[],"name":"办公桌椅","path":"办公设备,办公桌椅","pathId":"58,61","pid":58,"sort":100,"updateTime":1560824988000,"version":2},{"createTime":1560825079000,"deleted":false,"enabled":true,"id":65,"list":[],"name":"平板","path":"办公设备,平板","pathId":"58,65","pid":58,"sort":100,"updateTime":1560825078000,"version":1},{"createTime":1560825086000,"deleted":false,"enabled":true,"id":66,"list":[],"name":"手机","path":"办公设备,手机","pathId":"58,66","pid":58,"sort":100,"updateTime":1560825085000,"version":1},{"createTime":1560825093000,"deleted":false,"enabled":true,"id":67,"list":[],"name":"配件","path":"办公设备,配件","pathId":"58,67","pid":58,"sort":100,"updateTime":1560825093000,"version":1}],"name":"办公设备","path":"办公设备","pathId":"58","pid":0,"sort":100,"updateTime":1560824988000,"version":2},{"createTime":1560825106000,"deleted":false,"enabled":true,"id":68,"list":[{"createTime":1560825122000,"deleted":false,"enabled":true,"id":69,"list":[],"name":"安装升级","path":"增值服务,安装升级","pathId":"68,69","pid":68,"sort":100,"updateTime":1560825121000,"version":1},{"createTime":1560825132000,"deleted":false,"enabled":true,"id":70,"list":[],"name":"软件预装","path":"增值服务,软件预装","pathId":"68,70","pid":68,"sort":100,"updateTime":1560825131000,"version":1},{"createTime":1560825146000,"deleted":false,"enabled":true,"id":71,"list":[],"name":"上门维修","path":"增值服务,上门维修","pathId":"68,71","pid":68,"sort":100,"updateTime":1560825146000,"version":1}],"name":"增值服务","path":"增值服务","pathId":"68","pid":0,"sort":100,"updateTime":1560825105000,"version":1}]
     * message : SUCCESS
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : 1559285258000
         * deleted : false
         * enabled : true
         * id : 41
         * list : [{"createTime":1559293018000,"deleted":false,"enabled":true,"id":50,"list":[],"name":"台式电脑","path":"办公电脑,台式电脑","pathId":"41,50","pid":41,"sort":103,"updateTime":1560495692000,"version":5},{"createTime":1559285265000,"deleted":false,"enabled":true,"id":42,"list":[],"name":"笔记本","path":"办公电脑,笔记本","pathId":"41,42","pid":41,"sort":101,"updateTime":1560495650000,"version":3},{"createTime":1560824945000,"deleted":false,"enabled":true,"id":62,"list":[],"name":"一体机","path":"办公电脑,一体机","pathId":"41,62","pid":41,"sort":100,"updateTime":1560824945000,"version":1},{"createTime":1560824956000,"deleted":false,"enabled":true,"id":63,"list":[],"name":"单主机","path":"办公电脑,单主机","pathId":"41,63","pid":41,"sort":100,"updateTime":1560824955000,"version":1},{"createTime":1560824965000,"deleted":false,"enabled":true,"id":64,"list":[],"name":"显示器","path":"办公电脑,显示器","pathId":"41,64","pid":41,"sort":100,"updateTime":1560824964000,"version":1}]
         * name : 办公电脑
         * path : 办公电脑
         * pathId : 41
         * pid : 0
         * sort : 100
         * updateTime : 1559293005000
         * version : 2
         */

        private long createTime;
        private boolean deleted;
        private boolean enabled;
        private int id;
        private String name;
        private String path;
        private String pathId;
        private int pid;
        private int sort;
        private long updateTime;
        private int version;
        private List<ListBean> list;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getPathId() {
            return pathId;
        }

        public void setPathId(String pathId) {
            this.pathId = pathId;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * createTime : 1559293018000
             * deleted : false
             * enabled : true
             * id : 50
             * list : []
             * name : 台式电脑
             */

            private long createTime;
            private boolean deleted;
            private boolean enabled;
            private int id;
            private String name;
            private String path;
            private String pathId;
            private int pid;
            private int sort;
            private long updateTime;
            private int version;
            private List<ListBean> list;

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getPathId() {
                return pathId;
            }

            public void setPathId(String pathId) {
                this.pathId = pathId;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }
        }
    }
}

