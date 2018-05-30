package com.me.demo.common;

/**
 * 系统常量类
 * 
 * @deprecated 如果是民安系统，请用民安com.chinainsurance.application.common.Constants类
 *             其它老架构的可以继续使用。
 */
public class Constants implements PlatformTaskConstants, PrpallTaskConstants, ClaimTaskConstants,
        UndwrtTaskConstants, ReinsTaskConstants {
    // 以下为9种标准操作方法
    /**
     * 准备查询，即显示查询条件
     */
    public static final String PREPAREQUERY = "prepareQuery";

    /**
     * 查询
     */
    public static final String QUERY = "query";

    /**
     * 查询后继续向下翻页
     */
    public static final String QUERYCONTINUE = "queryContinue";

    /**
     * 察看结果
     */
    public static final String VIEW = "view";

    /**
     * 准备新增记录，即准备显示新增页面数据
     */
    public static final String PREPAREINSERT = "prepareInsert";

    /**
     * 新增记录
     */
    public static final String INSERT = "insert";

    /**
     * 删除记录
     */
    public static final String DELETE = "delete";

    /**
     * 准备更新，即准备显示更新页面数据
     */
    public static final String PREPAREUPDATE = "prepareUpdate";

    /**
     * 更新记录
     */
    public static final String UPDATE = "update";

    /**
     * 登录
     */
    public static final String LOGIN = "login";

    /**
     * 注销
     */
    public static final String LOGOUT = "logout";

    /**
     * 操作成功
     */
    public static final String SUCCESS = "succes";

    /**
     * 操作失败
     */
    public static final String FAILURE = "failure";

    /**
     * 重复操作,即令牌非法
     */
    public static final String TOKENINVALID = "tokenInvalid";

    /**
     * 非法
     */
    public static final String INVALID = "invalid";

    /**
     * 字段之间的分割符
     */
    public static final String FIELD_SEPARATOR = "_FIELD_SEPARATOR_";

    /**
     * 一组代码之间的分割符
     */
    public static final String GROUP_SEPARATOR = "_GROUP_SEPARATOR_";

    /** 本机构 */
    public static final int SELF_COMPANY = 1;

    /** 本级机构及本级机构 */
    public static final int SAME_COMPANY = 2;

    /** 本级构及本级机构及下级机构 */
    public static final int SUB_COMPANY = 3;

    /** 本级构及本级机构及下级机构及所有上级允许察看的机构 */
    public static final int UPPER_COMPANY = 4;

}

/**
 * 业务系统任务常量
 */
interface PrpallTaskConstants {
    /** 业务系统(含登录及显示菜单等) */
    public static final String TASK_PRPALL = "prpall";

    /** 投保管理 */
    public static final String TASK_PROPOSAL = "prpall.proposal";

    /** 投保单录入 */
    public static final String TASK_PROPOSAL_INSERT = "prpall.proposal.insert";

    /** 投保单删除 */
    public static final String TASK_PROPOSAL_DELETE = "prpall.proposal.delete";

    /** 投保单修改 */
    public static final String TASK_PROPOSAL_UPDATE = "prpall.proposal.update";

    /** 投保单注销 */
    public static final String TASK_PROPOSAL_WRITEOFF = "prpall.proposal.writeoff";

    /** 投保单查询 */
    public static final String TASK_PROPOSAL_QUERY = "prpall.proposal.query";

    /** 投保单打印 */
    public static final String TASK_PROPOSAL_PRINT = "prpall.proposal.print";

    /** 投保单提交核保 */
    public static final String TASK_PROPOSAL_SUBMITUNDWRT = "prpall.proposal.submitundwrt";

    /** 承保管理 */
    public static final String TASK_POLICY = "prpall.policy";

    /** 保单录入 */
    public static final String TASK_POLICY_INSERT = "prpall.policy.insert";

    /** 保单删除 */
    public static final String TASK_POLICY_DELETE = "prpall.policy.delete";

    /** 保单修改 */
    public static final String TASK_POLICY_UPDATE = "prpall.policy.update";

    /** 保单查询 */
    public static final String TASK_POLICY_QUERY = "prpall.policy.query";

    /** 保单打印 */
    public static final String TASK_POLICY_PRINT = "prpall.policy.print";

    /** 提交核保 */
    public static final String TASK_POLICY_SUBMITUNDWRT = "prpall.policy.submitundwrt";

    /** 批改管理 */
    public static final String TASK_ENDORSE = "prpall.endorse";

    /** 批单录入 */
    public static final String TASK_ENDORSE_INSERT = "prpall.endorse.insert";

    /** 批单删除 */
    public static final String TASK_ENDORSE_DELETE = "prpall.endorse.delete";

    /** 批单修改 */
    public static final String TASK_ENDORSE_UPDATE = "prpall.endorse.update";

    /** 批单查询 */
    public static final String TASK_ENDORSE_QUERY = "prpall.endorse.query";

    /** 批单打印 */
    public static final String TASK_ENDORSE_PRINT = "prpall.endorse.print";

    /** 提交核批 */
    public static final String TASK_ENDORSE_SUBMITUNDWRT = "prpall.endorse.submitundwrt";

    /** 影像资料 */
    public static final String TASK_DOCUMENT = "prpall.document";

    /** 影像资料上传 */
    public static final String TASK_DOCUMENT_UPLOAD = "prpall.document.upload";

    /** 影像资料查询 */
    public static final String TASK_DOCUMENT_QUERY = "prpall.document.query";

    /** 收付处理 */
    public static final String TASK_CONFIRMATION = "prpall.confirmation";

    /** 收付款确认 */
    public static final String TASK_CONFIRMATION_COMMIT = "prpall.confirmation.commit";

    /** 支付单 */
    public static final String TASK_DEBITNOTE = "prpall.debitnote";

    /** 发票打印 */
    public static final String TASK_INVOICEPRINT = "prpall.invoiceprint";

    /** 再保结算 */
    public static final String TASK_SETTLEMENT = "prpall.settlement";

    /** 综合查询 */
    public static final String TASK_QUERY = "prpall.query";

    /** 业务综合查询 */
    public static final String TASK_QUERY_SUM = "prpall.query.sum";

    /** 综合统计 */
    public static final String TASK_STAT = "prpall.stat";

    /** 生成报表 */
    public static final String TASK_STAT_REPORT = "prpall.stat.report";

    /** 准备金管理 */
    public static final String TASK_RESERVE = "prpall.reserve";

    /** 准备金参数配置 */
    public static final String TASK_RESERVE_PARAMCONFIG = "prpall.reserve.paramconfig";

    /** 未决赔款准备金 */
    public static final String TASK_RESERVE_OUTSTLOSS = "prpall.reserve.outstloss";

    /** 未到期责任准备金 */
    public static final String TASK_RESERVE_NODUTY = "prpall.reserve.noduty";

    /** 准备金报表 */
    public static final String TASK_RESERVE_REPORT = "prpall.reserve.report";

    /** 送入财务 */
    public static final String TASK_RESERVE_ACCOUNT = "prpall.reserve.account";

    /** 收付中间成本 */
    public static final String TASK_CONFIRMATION_MIDDLECOST = "prpall.confirmation.middlecost";

    /** 批改中间成本 */
    public static final String TASK_ENDORSE_MIDDLECOST = "prpall.endorse.middlecost";

    /** 承保中间成本 */
    public static final String TASK_POLICY_MIDDLECOST = "prpall.policy.middlecost";

    /** 投保中间成本 */
    public static final String TASK_PROPOSAL_MIDDLECOST = "prpall.proposal.middlecost";

    /** 批改全额退保 */
    public static final String TASK_ENDORSE_ALLQUIT = "prpall.endorse.allquit";

    /** 取消收付款确认（删除） */
    public static final String TASK_CONFIRMATION_SFFDEL = "prpall.confirmation.sffdel";

    /** 取消收付款确认（对冲） */
    public static final String TASK_CONFIRMATION_SFFQX = "prpall.confirmation.sffqx";

    /** 法定三者管理 */
    public static final String TASK_PROPOSAL_FDSZ = "prpall.proposal.fdsz";

    /** 批改手续费 */
    public static final String TASK_ENDORSE_COMMISSION = "prpall.endorse.commission";

    /** 投保管理费比例 */
    public static final String TASK_PROPOSAL_MANAGEFEERATE = "prpall.proposal.managefeerate";

    /** 承保管理费比例 */
    public static final String TASK_POLICY_MANAGEFEERATE = "prpall.policy.managefeerate";

    /** 批改管理费比例 */
    public static final String TASK_ENDORSE_MANAGEFEERATE = "prpall.endorse.managefeerate";
}

/**
 * 平台系统任务常量
 */
interface PlatformTaskConstants {
    /** 平台配置系统(含登录及显示菜单等) */
    public static final String TASK_PLATFORM = "platform";

    /** 参数管理 */
    public static final String TASK_PARAM = "platform.param";

    /** 录入参数 */
    public static final String TASK_PARAM_INSERT = "platform.param.insert";

    /** 删除参数 */
    public static final String TASK_PARAM_DELETE = "platform.param.delete";

    /** 修改参数 */
    public static final String TASK_PARAM_UPDATE = "platform.param.update";

    /** 查询参数 */
    public static final String TASK_PARAM_QUERY = "platform.param.query";

    /** 菜单管理 */
    public static final String TASK_MENU = "platform.menu";

    /** 配置菜单 */
    public static final String TASK_MENU_CONFIG = "platform.menu.config";

    /** 工作流管理 */
    public static final String TASK_WORKFLOW = "platform.workflow";

    /** 模板管理 */
    public static final String TASK_WORKFLOW_MODEL = "platform.workflow.model";

    /** 模板创建 */
    public static final String TASK_WORKFLOW_MODEL_EDITGRAPHTEMPLATE = "platform.workflow.model.editgraphtemplate";

    /** 模板维护 */
    public static final String TASK_WORKFLOW_MODEL_SWFMODELQUERY = "platform.workflow.model.swfmodelquery";

    /** 模板分配 */
    public static final String TASK_WORKFLOW_MODEL_ASSIGN = "platform.workflow.model.assign";

    /** 产品配置 */
    public static final String TASK_PRODUCT = "platform.product";

    /** 产品属性管理 */
    public static final String TASK_PRODUCT_PRODUCTATTR = "platform.product.productattr";

    /** 录入产品属性 */
    public static final String TASK_PRODUCT_PRODUCTATTR_INSERT = "platform.product.productattr.insert";

    /** 删除产品属性 */
    public static final String TASK_PRODUCT_PRODUCTATTR_DELETE = "platform.product.productattr.delete";

    /** 修改产品属性 */
    public static final String TASK_PRODUCT_PRODUCTATTR_UPDATE = "platform.product.productattr.update";

    /** 查询产品属性 */
    public static final String TASK_PRODUCT_PRODUCTATTR_QUERY = "platform.product.productattr.query";

    /** 险类管理 */
    public static final String TASK_PRODUCT_CLASS = "platform.product.class";

    /** 录入险类 */
    public static final String TASK_PRODUCT_CLASS_INSERT = "platform.product.class.insert";

    /** 删除险类 */
    public static final String TASK_PRODUCT_CLASS_DELETE = "platform.product.class.delete";

    /** 修改险类 */
    public static final String TASK_PRODUCT_CLASS_UPDATE = "platform.product.class.update";

    /** 查询险类 */
    public static final String TASK_PRODUCT_CLASS_QUERY = "platform.product.class.query";

    /** 险种 */
    public static final String TASK_PRODUCT_RISK = "platform.product.risk";

    /** 录入险种 */
    public static final String TASK_PRODUCT_RISK_INSERT = "platform.product.risk.insert";

    /** 删除险种 */
    public static final String TASK_PRODUCT_RISK_DELETE = "platform.product.risk.delete";

    /** 修改险种 */
    public static final String TASK_PRODUCT_RISK_UPDATE = "platform.product.risk.update";

    /** 查询险种 */
    public static final String TASK_PRODUCT_RISK_QUERY = "platform.product.risk.query";

    /** 配置险种 */
    public static final String TASK_PRODUCT_RISK_CONFIG = "platform.product.risk.config";

    /** 配置险别 */
    public static final String TASK_PRODUCT_RISK_CONFIGCLASS = "platform.product.risk.configclass";

    /** 险种复制 */
    public static final String TASK_PRODUCT_RISK_COPY = "platform.product.risk.copy";

    /** 单号初始化 */
    public static final String TASK_PRODUCT_NOINIT = "platform.product.noinit";

    /** 业务单号初始化 */
    public static final String TASK_PRODUCT_NOINIT_PRPINS = "platform.product.noinit.prpins";

    /** 再保单号初始化 */
    public static final String TASK_PRODUCT_NOINIT_REINS = "platform.product.noinit.reins";

    /** 费率维护 */
    public static final String TASK_RATE = "platform.rate";

    /** 费率因子设置 */
    public static final String TASK_RATE_RATEFACTOR = "platform.rate.ratefactor";

    /** 录入费率因子 */
    public static final String TASK_RATE_RATEFACTOR_INSERT = "platform.rate.ratefactor.insert";

    /** 删除费率因子 */
    public static final String TASK_RATE_RATEFACTOR_DELETE = "platform.rate.ratefactor.delete";

    /** 费率条件设置 */
    public static final String TASK_RATE_RATECOND = "platform.rate.ratecond";

    /** 录入费率条件 */
    public static final String TASK_RATE_RATECOND_INSERT = "platform.rate.ratecond.insert";

    /** 删除费率条件 */
    public static final String TASK_RATE_RATECOND_DELETE = "platform.rate.ratecond.delete";

    /** 修改费率条件 */
    public static final String TASK_RATE_RATECOND_UPDATE = "platform.rate.ratecond.update";

    /** 查询费率条件 */
    public static final String TASK_RATE_RATECOND_QUERT = "platform.rate.ratecond.quert";

    /** 车型分组设置 */
    public static final String TASK_RATE_CARMODELGROUP = "platform.rate.carmodelgroup";

    /** 录入车型分组 */
    public static final String TASK_RATE_CARMODELGROUP_INSERT = "platform.rate.carmodelgroup.insert";

    /** 删除车型分组 */
    public static final String TASK_RATE_CARMODELGROUP_DELETE = "platform.rate.carmodelgroup.delete";

    /** 修改车型分组 */
    public static final String TASK_RATE_CARMODELGROUP_UPDATE = "platform.rate.carmodelgroup.update";

    /** 查询车型分组 */
    public static final String TASK_RATE_CARMODELGROUP_QUERY = "platform.rate.carmodelgroup.query";

    /** 费率代码设置 */
    public static final String TASK_RATE_RATEUSUAL = "platform.rate.rateusual";

    /** 录入费率代码 */
    public static final String TASK_RATE_RATEUSUAL_INSERT = "platform.rate.rateusual.insert";

    /** 删除费率代码 */
    public static final String TASK_RATE_RATEUSUAL_DELETE = "platform.rate.rateusual.delete";

    /** 修改费率代码 */
    public static final String TASK_RATE_RATEUSUAL_UPDATE = "platform.rate.rateusual.update";

    /** 查询费率代码 */
    public static final String TASK_RATE_RATEUSUAL_QUERY = "platform.rate.rateusual.query";

    /** 查询费率优惠代码 */
    public static final String TASK_RATE_RATEUSUAL_QUERYDETAIL = "platform.rate.rateusual.querydetail";

    /** 系数分组设置 */
    public static final String TASK_RATE_RATEGROUP = "platform.rate.rategroup";

    /** 录入系数分组 */
    public static final String TASK_RATE_RATEGROUP_INSERT = "platform.rate.rategroup.insert";

    /** 删除系数分组 */
    public static final String TASK_RATE_RATEGROUP_DELETE = "platform.rate.rategroup.delete";

    /** 修改系数分组 */
    public static final String TASK_RATE_RATEGROUP_UPDATE = "platform.rate.rategroup.update";

    /** 查询系数分组 */
    public static final String TASK_RATE_RATEGROUP_QUERY = "platform.rate.rategroup.query";

    /** 查询费率优惠代码 */
    public static final String TASK_RATE_RATEGROUP_QUERYDETAIL = "platform.rate.rategroup.querydetail";

    /** 优惠系数设置 */
    public static final String TASK_RATE_PROFIT = "platform.rate.profit";

    /** 优惠系数设置 */
    public static final String TASK_RATE_PROFIT_CONFIG = "platform.rate.profit.config";

    /** 批量导入费率数据 */
    public static final String TASK_RATE_BATCH = "platform.rate.batch";

    /** 批量导入费率数据 */
    public static final String TASK_RATE_BATCH_IMPORT = "platform.rate.batch.import";

    /** 机构管理 */
    public static final String TASK_COMPANY = "platform.company";

    /** 录入机构 */
    public static final String TASK_COMPANY_INSERT = "platform.company.insert";

    /** 删除机构 */
    public static final String TASK_COMPANY_DELETE = "platform.company.delete";

    /** 修改机构 */
    public static final String TASK_COMPANY_UPDATE = "platform.company.update";

    /** 查询机构 */
    public static final String TASK_COMPANY_QUERY = "platform.company.query";

    /** 员工管理 */
    public static final String TASK_USER = "platform.user";

    /** 录入员工 */
    public static final String TASK_USER_INSERT = "platform.user.insert";

    /** 删除员工 */
    public static final String TASK_USER_DELETE = "platform.user.delete";

    /** 修改员工 */
    public static final String TASK_USER_UPDATE = "platform.user.update";

    /** 查询员工 */
    public static final String TASK_USER_QUERY = "platform.user.query";

    /** 业务权限管理 */
    public static final String TASK_PRPUSERGRADE = "platform.prpusergrade";

    /** 录入员工权限 */
    public static final String TASK_PRPUSERGRADE_INSERT = "platform.prpusergrade.insert";

    /** 删除员工权限 */
    public static final String TASK_PRPUSERGRADE_DELETE = "platform.prpusergrade.delete";

    /** 修改员工权限 */
    public static final String TASK_PRPUSERGRADE_UPDATE = "platform.prpusergrade.update";

    /** 查询员工权限 */
    public static final String TASK_PRPUSERGRADE_QUERY = "platform.prpusergrade.query";

    /** 复制员工权限 */
    public static final String TASK_PRPUSERGRADE_COPY = "platform.prpusergrade.copy";

    /** 双核权限设置 */
    public static final String TASK_UWPOWER = "platform.uwpower";

    /** 双核条件 */
    public static final String TASK_UWPOWER_CONDITION = "platform.uwpower.condition";

    /** 录入双核条件 */
    public static final String TASK_UWPOWER_CONDITION_INSERT = "platform.uwpower.condition.insert";

    /** 删除双核条件 */
    public static final String TASK_UWPOWER_CONDITION_DELETE = "platform.uwpower.condition.delete";

    /** 修改双核条件 */
    public static final String TASK_UWPOWER_CONDITION_UPDATE = "platform.uwpower.condition.update";

    /** 查询双核条件 */
    public static final String TASK_UWPOWER_CONDITION_QUERY = "platform.uwpower.condition.query";

    /** 双核因子 */
    public static final String TASK_UWPOWER_FACTOR = "platform.uwpower.factor";

    /** 修改双核因子 */
    public static final String TASK_UWPOWER_FACTOR_UPDATE = "platform.uwpower.factor.update";

    /** 查询双核因子 */
    public static final String TASK_UWPOWER_FACTOR_QUERY = "platform.uwpower.factor.query";

    /** 权限管理 */
    public static final String TASK_POWER = "platform.power";

    /** 岗位管理 */
    public static final String TASK_POWER_GRADE = "platform.power.grade";

    /** 录入岗位 */
    public static final String TASK_POWER_GRADE_INSERT = "platform.power.grade.insert";

    /** 删除岗位 */
    public static final String TASK_POWER_GRADE_DELETE = "platform.power.grade.delete";

    /** 修改岗位 */
    public static final String TASK_POWER_GRADE_UPDATE = "platform.power.grade.update";

    /** 查询岗位 */
    public static final String TASK_POWER_GRADE_QUERY = "platform.power.grade.query";

    /** 员工权限管理 */
    public static final String TASK_POWER_USERGRADE = "platform.power.usergrade";

    /** 引入员工 */
    public static final String TASK_POWER_USERGRADE_INSERT = "platform.power.usergrade.insert";

    /** 移出员工 */
    public static final String TASK_POWER_USERGRADE_DELETE = "platform.power.usergrade.delete";

    /** 查询员工 */
    public static final String TASK_POWER_USERGRADE_QUERY = "platform.power.usergrade.query";

    /** 增加员工岗位 */
    public static final String TASK_POWER_USERGRADE_QUERYGRADE_INSERT = "platform.power.usergrade.querygrade.insert";

    /** 删除员工岗位 */
    public static final String TASK_POWER_USERGRADE_QUERYGRADE_DELETE = "platform.power.usergrade.querygrade.delete";

    /** 配置功能权限 */
    public static final String TASK_POWER_USERGRADE_QUERYGRADE_CONFIGTASK = "platform.power.usergrade.querygrade.configtask";

    /** 配置业务权限 */
    public static final String TASK_POWER_USERGRADE_QUERYGRADE_CONFIGPOWER = "platform.power.usergrade.querygrade.configpower";

    /** 客户资料管理 */
    public static final String TASK_CUSTOMER = "platform.customer";

    /** 团体客户资料管理 */
    public static final String TASK_CUSTOMER_CUSTOMERUNIT = "platform.customer.customerunit";

    /** 录入团体客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERUNIT_INSERT = "platform.customer.customerunit.insert";

    /** 删除团体客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERUNIT_DELETE = "platform.customer.customerunit.delete";

    /** 修改团体客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERUNIT_UPDATE = "platform.customer.customerunit.update";

    /** 查询团体客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERUNIT_QUERY = "platform.customer.customerunit.query";

    /** 注销团体客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERUNIT_WRITEOFF = "platform.customer.customerunit.writeoff";

    /** 个人客户资料管理 */
    public static final String TASK_CUSTOMER_CUSTOMERIDV = "platform.customer.customeridv";

    /** 录入个人客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERIDV_INSERT = "platform.customer.customeridv.insert";

    /** 删除个人客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERIDV_DELETE = "platform.customer.customeridv.delete";

    /** 修改个人客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERIDV_UPDATE = "platform.customer.customeridv.update";

    /** 查询个人客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERIDV_QUERY = "platform.customer.customeridv.query";

    /** 注销个人客户资料 */
    public static final String TASK_CUSTOMER_CUSTOMERIDV_WRITEOFF = "platform.customer.customeridv.writeoff";

    /** 代理协议管理 */
    public static final String TASK_AGENT = "platform.agent";

    /** 代理人管理 */
    public static final String TASK_AGENT_AGENT = "platform.agent.agent";

    /** 录入代理人 */
    public static final String TASK_AGENT_AGENT_INSERT = "platform.agent.agent.insert";

    /** 修改代理人 */
    public static final String TASK_AGENT_AGENT_UPDATE = "platform.agent.agent.update";

    /** 查询代理人 */
    public static final String TASK_AGENT_AGENT_QUERY = "platform.agent.agent.query";

    /** 协议管理 */
    public static final String TASK_AGENT_AGREEMENT = "platform.agent.agreement";

    /** 录入协议 */
    public static final String TASK_AGENT_AGREEMENT_INSERT = "platform.agent.agreement.insert";

    /** 修改协议 */
    public static final String TASK_AGENT_AGREEMENT_UPDATE = "platform.agent.agreement.update";

    /** 查询协议 */
    public static final String TASK_AGENT_AGREEMENT_QUERY = "platform.agent.agreement.query";

    /** 运行管理 */
    public static final String TASK_RUN = "platform.run";

    /** 操作日志 */
    public static final String TASK_RUN_OPERATEREC = "platform.run.operaterec";

    /** 查询操作日志 */
    public static final String TASK_RUN_OPERATEREC_QUERY = "platform.run.operaterec.query";

    /** 清除操作日志 */
    public static final String TASK_RUN_OPERATEREC_DELETE = "platform.run.operaterec.delete";

    /** 代码管理 */
    public static final String TASK_CODE = "platform.code";

    /** 币别管理 */
    public static final String TASK_CODE_CURRENCY = "platform.code.currency";

    /** 录入币别 */
    public static final String TASK_CODE_CURRENCY_INSERT = "platform.code.currency.insert";

    /** 删除币别 */
    public static final String TASK_CODE_CURRENCY_DELETE = "platform.code.currency.delete";

    /** 修改币别 */
    public static final String TASK_CODE_CURRENCY_UPDATE = "platform.code.currency.update";

    /** 查询币别 */
    public static final String TASK_CODE_CURRENCY_QUERY = "platform.code.currency.query";

    /** 通用代码类管理 */
    public static final String TASK_CODE_CODE = "platform.code.code";

    /** 录入通用代码类 */
    public static final String TASK_CODE_CODE_INSERT = "platform.code.code.insert";

    /** 删除通用代码类 */
    public static final String TASK_CODE_CODE_DELETE = "platform.code.code.delete";

    /** 修改通用代码类 */
    public static final String TASK_CODE_CODE_UPDATE = "platform.code.code.update";

    /** 查询通用代码类 */
    public static final String TASK_CODE_CODE_QUERY = "platform.code.code.query";

    /** 报表代码管理 */
    public static final String TASK_CODE_REPORT = "platform.code.report";

    /** 录入报表代码 */
    public static final String TASK_CODE_REPORT_INSERT = "platform.code.report.insert";

    /** 删除报表代码 */
    public static final String TASK_CODE_REPORT_DELETE = "platform.code.report.delete";

    /** 修改报表代码 */
    public static final String TASK_CODE_REPORT_UPDATE = "platform.code.report.update";

    /** 查询报表代码 */
    public static final String TASK_CODE_REPORT_QUERY = "platform.code.report.query";

    /** 折旧率管理 */
    public static final String TASK_CODE_DEPRECATERATE = "platform.code.deprecaterate";

    /** 录入折旧率 */
    public static final String TASK_CODE_DEPRECATERATE_INSERT = "platform.code.deprecaterate.insert";

    /** 删除折旧率 */
    public static final String TASK_CODE_DEPRECATERATE_DELETE = "platform.code.deprecaterate.delete";

    /** 修改折旧率 */
    public static final String TASK_CODE_DEPRECATERATE_UPDATE = "platform.code.deprecaterate.update";

    /** 查询折旧率 */
    public static final String TASK_CODE_DEPRECATERATE_QUERY = "platform.code.deprecaterate.query";

    /** 兑换率管理 */
    public static final String TASK_CODE_EXCH = "platform.code.exch";

    /** 录入兑换率 */
    public static final String TASK_CODE_EXCH_INSERT = "platform.code.exch.insert";

    /** 删除兑换率 */
    public static final String TASK_CODE_EXCH_DELETE = "platform.code.exch.delete";

    /** 修改兑换率 */
    public static final String TASK_CODE_EXCH_UPDATE = "platform.code.exch.update";

    /** 查询兑换率 */
    public static final String TASK_CODE_EXCH_QUERY = "platform.code.exch.query";

    /** 条款代码管理 */
    public static final String TASK_CODE_CLAUSE = "platform.code.clause";

    /** 录入条款代码 */
    public static final String TASK_CODE_CLAUSE_INSERT = "platform.code.clause.insert";

    /** 删除条款代码 */
    public static final String TASK_CODE_CLAUSE_DELETE = "platform.code.clause.delete";

    /** 修改条款代码 */
    public static final String TASK_CODE_CLAUSE_UPDATE = "platform.code.clause.update";

    /** 查询条款代码 */
    public static final String TASK_CODE_CLAUSE_QUERY = "platform.code.clause.query";

    /** 检验人代码管理 */
    public static final String TASK_CODE_IDENTIFIER = "platform.code.identifier";

    /** 录入检验人代码 */
    public static final String TASK_CODE_IDENTIFIER_INSERT = "platform.code.identifier.insert";

    /** 删除检验人代码 */
    public static final String TASK_CODE_IDENTIFIER_DELETE = "platform.code.identifier.delete";

    /** 修改检验人代码 */
    public static final String TASK_CODE_IDENTIFIER_UPDATE = "platform.code.identifier.update";

    /** 查询检验人代码 */
    public static final String TASK_CODE_IDENTIFIER_QUERY = "platform.code.identifier.query";

    /** 港口代码管理 */
    public static final String TASK_CODE_PORT = "platform.code.port";

    /** 录入港口代码 */
    public static final String TASK_CODE_PORT_INSERT = "platform.code.port.insert";

    /** 删除港口代码 */
    public static final String TASK_CODE_PORT_DELETE = "platform.code.port.delete";

    /** 修改港口代码 */
    public static final String TASK_CODE_PORT_UPDATE = "platform.code.port.update";

    /** 查询港口代码 */
    public static final String TASK_CODE_PORT_QUERY = "platform.code.port.query";

    /** 车型代码管理 */
    public static final String TASK_CODE_CARMODEL = "platform.code.carmodel";

    /** 录入车型代码 */
    public static final String TASK_CODE_CARMODEL_INSERT = "platform.code.carmodel.insert";

    /** 删除车型代码 */
    public static final String TASK_CODE_CARMODEL_DELETE = "platform.code.carmodel.delete";

    /** 修改车型代码 */
    public static final String TASK_CODE_CARMODEL_UPDATE = "platform.code.carmodel.update";

    /** 查询车型代码 */
    public static final String TASK_CODE_CARMODEL_QUERY = "platform.code.carmodel.query";

    /** 飞机管理 */
    public static final String TASK_CODE_PLANE = "platform.code.plane";

    /** 录入飞机 */
    public static final String TASK_CODE_PLANE_INSERT = "platform.code.plane.insert";

    /** 删除飞机 */
    public static final String TASK_CODE_PLANE_DELETE = "platform.code.plane.delete";

    /** 修改飞机 */
    public static final String TASK_CODE_PLANE_UPDATE = "platform.code.plane.update";

    /** 查询飞机 */
    public static final String TASK_CODE_PLANE_QUERY = "platform.code.plane.query";

    /** 船舶管理 */
    public static final String TASK_CODE_SHIP = "platform.code.ship";

    /** 录入船舶 */
    public static final String TASK_CODE_SHIP_INSERT = "platform.code.ship.insert";

    /** 删除船舶 */
    public static final String TASK_CODE_SHIP_DELETE = "platform.code.ship.delete";

    /** 修改船舶 */
    public static final String TASK_CODE_SHIP_UPDATE = "platform.code.ship.update";

    /** 查询船舶 */
    public static final String TASK_CODE_SHIP_QUERY = "platform.code.ship.query ";

    /** 代赔地区和公司管理 */
    public static final String TASK_CODE_AGENTCOM = "platform.code.agentcom";

    /** 录入代赔地区和公司 */
    public static final String TASK_CODE_AGENTCOM_INSERT = "platform.code.agentcom.insert";

    /** 删除代赔地区和公司 */
    public static final String TASK_CODE_AGENTCOM_DELETE = "platform.code.agentcom.delete";

    /** 修改代赔地区和公司 */
    public static final String TASK_CODE_AGENTCOM_UPDATE = "platform.code.agentcom.update";

    /** 查询代赔地区和公司 */
    public static final String TASK_CODE_AGENTCOM_QUERY = "platform.code.agentcom.query";

    /** 帐户管理 */
    public static final String TASK_CODE_ACCOUNT = "platform.code.account";

    /** 录入帐户 */
    public static final String TASK_CODE_ACCOUNT_INSERT = "platform.code.account.insert";

    /** 删除帐户 */
    public static final String TASK_CODE_ACCOUNT_DELETE = "platform.code.account.delete";

    /** 修改帐户 */
    public static final String TASK_CODE_ACCOUNT_UPDATE = "platform.code.account.update";

    /** 查询帐户 */
    public static final String TASK_CODE_ACCOUNT_QUERY = "platform.code.account.query";

    /** 再保财务科目管理 */
    public static final String TASK_CODE_ACCITEM = "platform.code.accitem";

    /** 录入再保财务科目 */
    public static final String TASK_CODE_ACCITEM_INSERT = "platform.code.accitem.insert";

    /** 删除再保财务科目 */
    public static final String TASK_CODE_ACCITEM_DELETE = "platform.code.accitem.delete";

    /** 修改再保财务科目 */
    public static final String TASK_CODE_ACCITEM_UPDATE = "platform.code.accitem.update";

    /** 查询再保财务科目 */
    public static final String TASK_CODE_ACCITEM_QUERY = "platform.code.accitem.query";

    /** 再保财务专项管理 */
    public static final String TASK_CODE_ARTITEM = "platform.code.artitem";

    /** 录入再保财务专项 */
    public static final String TASK_CODE_ARTITEM_INSERT = "platform.code.artitem.insert";

    /** 删除再保财务专项 */
    public static final String TASK_CODE_ARTITEM_DELETE = "platform.code.artitem.delete";

    /** 修改再保财务专项 */
    public static final String TASK_CODE_ARTITEM_UPDATE = "platform.code.artitem.update";

    /** 查询再保财务专项 */
    public static final String TASK_CODE_ARTITEM_QUERY = "platform.code.artitem.query";

    /** 再保专项管理 */
    public static final String TASK_CODE_ARTICLE = "platform.code.article";

    /** 录入再保专项 */
    public static final String TASK_CODE_ARTICLE_INSERT = "platform.code.article.insert";

    /** 删除再保专项 */
    public static final String TASK_CODE_ARTICLE_DELETE = "platform.code.article.delete";

    /** 修改再保专项 */
    public static final String TASK_CODE_ARTICLE_UPDATE = "platform.code.article.update";

    /** 查询再保专项 */
    public static final String TASK_CODE_ARTICLE_QUERY = "platform.code.article.query";

    /** 接受人管理 */
    public static final String TASK_CODE_REINS = "platform.code.reins";

    /** 录入接受人 */
    public static final String TASK_CODE_REINS_INSERT = "platform.code.reins.insert";

    /** 删除接受人 */
    public static final String TASK_CODE_REINS_DELETE = "platform.code.reins.delete";

    /** 修改接受人 */
    public static final String TASK_CODE_REINS_UPDATE = "platform.code.reins.update";

    /** 查询接受人 */
    public static final String TASK_CODE_REINS_QUERY = "platform.code.reins.query";

    /** 机构帐户管理 */
    public static final String TASK_CODE_COMACCOUNT = "platform.code.comaccount";

    /** 录入机构帐户 */
    public static final String TASK_CODE_COMACCOUNT_INSERT = "platform.code.comaccount.insert";

    /** 删除机构帐户 */
    public static final String TASK_CODE_COMACCOUNT_DELETE = "platform.code.comaccount.delete";

    /** 修改机构帐户 */
    public static final String TASK_CODE_COMACCOUNT_UPDATE = "platform.code.comaccount.update";

    /** 查询机构帐户 */
    public static final String TASK_CODE_COMACCOUNT_QUERY = "platform.code.comaccount.query";

    /** 伤残等级管理 */
    public static final String TASK_CODE_INJURYGRADE = "platform.code.injurygrade";

    /** 录入伤残等级 */
    public static final String TASK_CODE_INJURYGRADE_INSERT = "platform.code.injurygrade.insert";

    /** 删除伤残等级 */
    public static final String TASK_CODE_INJURYGRADE_DELETE = "platform.code.injurygrade.delete";

    /** 修改伤残等级 */
    public static final String TASK_CODE_INJURYGRADE_UPDATE = "platform.code.injurygrade.update";

    /** 查询伤残等级 */
    public static final String TASK_CODE_INJURYGRADE_QUERY = "platform.code.injurygrade.query";

    /** 产品属性险类关联管理 */
    public static final String TASK_PRODUCT_PRODUCTATTRGROUP = "product.productattrgroup";

    /** 产品属性险类关联录入 */
    public static final String TASK_PRODUCT_PRODUCTATTRGROUP_INSERT = "product.productattrgroup.insert";

    /** 产品属性险类关联删除 */
    public static final String TASK_PRODUCT_PRODUCTATTRGROUP_DELETE = "product.productattrgroup.delete";

    /** 产品属性险类关联修改 */
    public static final String TASK_PRODUCT_PRODUCTATTRGROUP_UPDATE = "product.productattrgroup.update";

    /** 产品属性险类关联查询 */
    public static final String TASK_PRODUCT_PRODUCTATTRGROUP_QUERY = "product.productattrgroup.query";

    /** 费用比例管理 */
    public static final String TASK_CODE_MANAGEFEERATE = "platform.code.managefeerate";

    /** 删除费用比例 */
    public static final String TASK_CODE_MANAGEFEERATE_DELETE = "platform.code.managefeerate.delete";

    /** 录入费用比例 */
    public static final String TASK_CODE_MANAGEFEERATE_INSERT = "platform.code.managefeerate.insert";

    /** 查询费用比例 */
    public static final String TASK_CODE_MANAGEFEERATE_QUERY = "platform.code.managefeerate.query";

    /** 修改费用比例 */
    public static final String TASK_CODE_MANAGEFEERATE_UPDATE = "platform.code.managefeerate.update";
}

/**
 * 理赔系统常量
 * 
 */
interface ClaimTaskConstants {
    /** 理赔处理 */
    public static final String TASK_CLAIM_ = "claim";

    /** 报案任务处理 */
    public static final String TASK_CLAIM_REGIST = "claim.regist";

    /** 报案任务录入 */
    public static final String TASK_CLAIM_REGIST_INSERT = "claim.regist.insert";

    /** 报案任务删除 */
    public static final String TASK_CLAIM_REGIST_DELETE = "claim.regist.delete";

    /** 报案任务修改 */
    public static final String TASK_CLAIM_REGIST_UPDATE = "claim.regist.update";

    /** 报案任务查询 */
    public static final String TASK_CLAIM_REGIST_QUERY = "claim.regist.query";

    /** 报案任务统计 */
    public static final String TASK_CLAIM_REGIST_STAT = "claim.regist.stat";

    /** 调度任务处理 */
    public static final String TASK_CLAIM_SCHEDULE = "claim.schedule";

    /** 调度任务录入 */
    public static final String TASK_CLAIM_SCHEDULE_INSERT = "claim.schedule.insert";

    /** 调度任务删除 */
    public static final String TASK_CLAIM_SCHEDULE_DELETE = "claim.schedule.delete";

    /** 调度任务修改 */
    public static final String TASK_CLAIM_SCHEDULE_UPDATE = "claim.schedule.update";

    /** 调度任务查询 */
    public static final String TASK_CLAIM_SCHEDULE_QUERY = "claim.schedule.query";

    /** 调度任务统计 */
    public static final String TASK_CLAIM_SCHEDULE_STAT = "claim.schedule.stat";

    /** 调查查勘处理 */
    public static final String TASK_CLAIM_CHECK = "claim.check";

    /** 调查查勘录入 */
    public static final String TASK_CLAIM_CHECK_INSERT = "claim.check.insert";

    /** 调查查勘删除 */
    public static final String TASK_CLAIM_CHECK_DELETE = "claim.check.delete";

    /** 调查查勘修改 */
    public static final String TASK_CLAIM_CHECK_UPDATE = "claim.check.update";

    /** 调查查勘查询 */
    public static final String TASK_CLAIM_CHECK_QUERY = "claim.check.query";

    /** 调查查勘统计 */
    public static final String TASK_CLAIM_CHECK_STAT = "claim.check.stat";

    /** 立案任务处理 */
    public static final String TASK_CLAIM_CLAIM = "claim.claim";

    /** 立案任务录入 */
    public static final String TASK_CLAIM_CLAIM_INSERT = "claim.claim.insert";

    /** 立案任务删除 */
    public static final String TASK_CLAIM_CLAIM_DELETE = "claim.claim.delete";

    /** 立案任务修改 */
    public static final String TASK_CLAIM_CLAIM_UPDATE = "claim.claim.update";

    /** 立案任务查询 */
    public static final String TASK_CLAIM_CLAIM_QUERY = "claim.claim.query";

    /** 立案任务统计 */
    public static final String TASK_CLAIM_CLAIM_STAT = "claim.claim.stat";

    /** 立案注销拒赔申请 */
    public static final String TASK_CLAIM_CLAIM_CANCEL = "claim.claim.cancel";

    /** 注销拒赔审核 */
    public static final String TASK_CLAIM_CANCEL = "claim.cancel";

    /** 注销拒赔录入 */
    public static final String TASK_CLAIM_CANCEL_INSERT = "claim.cancel.insert";

    /** 注销拒赔删除 */
    public static final String TASK_CLAIM_CANCEL_DELETE = "claim.cancel.delete";

    /** 注销拒赔修改 */
    public static final String TASK_CLAIM_CANCEL_UPDATE = "claim.cancel.update";

    /** 注销拒赔查询 */
    public static final String TASK_CLAIM_CANCEL_QUERY = "claim.cancel.query";

    /** 注销拒赔统计 */
    public static final String TASK_CLAIM_CANCEL_STAT = "claim.cancel.stat";

    /** 特殊赔案处理 */
    public static final String TASK_CLAIM_SPECIALCASE = "claim.specialcase";

    /** 特殊赔案录入 */
    public static final String TASK_CLAIM_SPECIALCASE_INSERT = "claim.specialcase.insert";

    /** 特殊赔案删除 */
    public static final String TASK_CLAIM_SPECIALCASE_DELETE = "claim.specialcase.delete";

    /** 特殊赔案修改 */
    public static final String TASK_CLAIM_SPECIALCASE_UPDATE = "claim.specialcase.update";

    /** 特殊赔案查询 */
    public static final String TASK_CLAIM_SPECIALCASE_QUERY = "claim.specialcase.query";

    /** 特殊赔案统计 */
    public static final String TASK_CLAIM_SPECIALCASE_STAT = "claim.specialcase.stat";

    /** 定损任务处理 */
    public static final String TASK_CLAIM_CERTAINLOSS = "claim.certainloss";

    /** 预赔任务处理 */
    public static final String TASK_CLAIM_PREPAY = "claim.prepay";

    /** 预赔任务录入 */
    public static final String TASK_CLAIM_PREPAY_INSERT = "claim.prepay.insert";

    /** 预赔任务删除 */
    public static final String TASK_CLAIM_PREPAY_DELETE = "claim.prepay.delete";

    /** 预赔任务修改 */
    public static final String TASK_CLAIM_PREPAY_UPDATE = "claim.prepay.update";

    /** 预赔任务查询 */
    public static final String TASK_CLAIM_PREPAY_QUERY = "claim.prepay.query";

    /** 预赔任务统计 */
    public static final String TASK_CLAIM_PREPAY_STAT = "claim.prepay.stat";

    /** 理算任务处理 */
    public static final String TASK_CLAIM_COMPENSATE = "claim.compensate";

    /** 理算任务录入 */
    public static final String TASK_CLAIM_COMPENSATE_INSERT = "claim.compensate.insert";

    /** 理算任务删除 */
    public static final String TASK_CLAIM_COMPENSATE_DELETE = "claim.compensate.delete";

    /** 理算任务修改 */
    public static final String TASK_CLAIM_COMPENSATE_UPDATE = "claim.compensate.update";

    /** 理算任务查询 */
    public static final String TASK_CLAIM_COMPENSATE_QUERY = "claim.compensate.query";

    /** 理算任务统计 */
    public static final String TASK_CLAIM_COMPENSATE_STAT = "claim.compensate.stat";

    /** 结案任务处理 */
    public static final String TASK_CLAIM_ENDCASE = "claim.endcase";

    /** 结案任务录入 */
    public static final String TASK_CLAIM_ENDCASE_INSERT = "claim.endcase.insert";

    /** 结案任务删除 */
    public static final String TASK_CLAIM_ENDCASE_DELETE = "claim.endcase.delete";

    /** 结案任务修改 */
    public static final String TASK_CLAIM_ENDCASE_UPDATE = "claim.endcase.update";

    /** 结案任务查询 */
    public static final String TASK_CLAIM_ENDCASE_QUERY = "claim.endcase.query";

    /** 结案任务统计 */
    public static final String TASK_CLAIM_ENDCASE_STAT = "claim.endcase.stat";

    /** 理赔打印处理 */
    public static final String TASK_CLAIM_PRINT = "claim.print";

    /** 理赔流程查询 */
    public static final String TASK_CLAIM_WORKFLOWQUERY = "claim.workflowquery";

    /** 理赔联系记录 */
    public static final String TASK_CLAIM_LINKERRECORD = "claim.linkerrecord";

    /** 调整估损金额 */
    public static final String TASK_CLAIM_EDITLOSS = "claim.editloss";

    /** 修复验车 */
    public static final String TASK_CLAIM_REPAIRCHECKCAR = "claim.repaircheckcar";

    /** 定损调度 */
    public static final String TASK_CLAIM_CERTAINLOSSSCHEDULE = "claim.certainlossschedule";

    /** 理赔核赔 */
    public static final String TASK_CLAIM_UNDWRT = "claim.undwrt";

    /** 险种权限分配 */
    public static final String TASK_CLAIM_RISKLIMIT = "claim.risklimit";

    /** 回访任务 */
    public static final String TASK_CLAIM_BACKVISIT = "claim.backvisit";

    /** 单证收集任务处理 */
    public static final String TASK_CLAIM_CERTIFY = "claim.certify";

    /** 工作流管理 */
    public static final String TASK_CLAIM_WORKFLOW = "claim.workflow";

    /** 个人信息 */
    public static final String TASK_CLAIM_PERSONMESSAGE = "claim.personmessage";

    /** 系统管理 */
    public static final String TASK_CLAIM_SYSTEMMANAGE = "claim.systemmanage";

    /** 综合管理平台 */
    public static final String TASK_CLAIM_MANAGEMENT = "claim.management";

    /** 查询统计 */
    public static final String TASK_CLAIM_MANAGEMENT_STAT = "claim.management.stat";

    /** 重开赔案 */
    public static final String TASK_CLAIM_RECASE = "claim.recase";

    /** 理赔报案注销 */
    public static final String TASK_CLAIM_REGIST_CANCEL = "claim.regist.cancel";
}

/**
 * 双核系统任务常量
 */
interface UndwrtTaskConstants {
    /** 双核系统 */
    public static final String TASK_UNDWRT = "undwrt";

    /** 核保处理 */
    public static final String TASK_UNDWRT_HEBAO = "undwrt.hebao";

    /** 查询核保任务 */
    public static final String TASK_UNDWRT_HEBAO_READ = "undwrt.hebao.read";

    /** 处理核保任务 */
    public static final String TASK_UNDWRT_HEBAO_WRITE = "undwrt.hebao.write";

    /** 核赔处理 */
    public static final String TASK_UNDWRT_HEPEI = "undwrt.hepei";

    /** 查询核赔任务 */
    public static final String TASK_UNDWRT_HEPEI_READ = "undwrt.hepei.read";

    /** 处理核赔任务 */
    public static final String TASK_UNDWRT_HEPEI_WRITE = "undwrt.hepei.write";

    /** 任务查询 */
    public static final String TASK_UNDWRT_QUERY = "undwrt.query";
}

/**
 * 再保系统任务常量
 */
interface ReinsTaskConstants {
    /** 再保 */
    public static final String TASK_REINS = "reins";

    /** 再保分出业务 */
    public static final String TASK_REINSOUT = "reins.reinsout";

    /** 再保分入业务 */
    public static final String TASK_REINSIN = "reins.reinsin";

    /** 再保确认 */
    public static final String TASK_REINSOUT_ENQUERY = "reins.reinsout.enquery";

    /** 临分询价 */
    public static final String TASK_REINSOUT_ENQUERY_DEAL = "reins.reinsout.enquery.deal";

    /** 分保单处理 */
    public static final String TASK_REINSOUT_REPOLICY = "reins.reinsout.repolicy";

    /** 分保单信息 */
    public static final String TASK_REINSOUT_REPOLICY_QUERY = "reins.reinsout.repolicy.query";

    /** 分保合约 */
    public static final String TASK_REINSOUT_REPOLICY_QUERY_TREATY = "reins.reinsout.repolicy.query.treaty";

    /** 分保临分 */
    public static final String TASK_REINSOUT_REPOLICY_QUERY_FACACC = "reins.reinsout.repolicy.query.facacc";

    /** 分保复核 */
    public static final String TASK_REINSOUT_REPOLICY_UNDERWRITE = "reins.reinsout.repolicy.underwrite";

    /** 单证打印 */
    public static final String TASK_REINSOUT_REPOLICY_PRINT = "reins.reinsout.repolicy.print";

    /** 危险单位处理 */
    public static final String TASK_REINSOUT_REPOLICY_DEALDANGER = "reins.reinsout.repolicy.dealdanger";

    /** 分批单处理 */
    public static final String TASK_REINSOUT_REENDER = "reins.reinsout.reendor";

    /** 分批单信息 */
    public static final String TASK_REINSOUT_REENDER_QUERY = "reins.reinsout.reendor.query";

    /** 分保合约 */
    public static final String TASK_REINSOUT_REENDOR_QUERY_TREATY = "reins.reinsout.reendor.query.treaty";

    /** 分保临分 */
    public static final String TASK_REINSOUT_REENDOR_QUERY_FACACC = "reins.reinsout.reendor.query.facacc";

    /** 分保复核 */
    public static final String TASK_REINSOUT_REENDER_UNDERWRITE = "reins.reinsout.reendor.underwrite";

    /** 单证打印 */
    public static final String TASK_REINSOUT_REENDER_PRINT = "reins.reinsout.reendor.print";

    /** 危险单位处理 */
    public static final String TASK_REINSOUT_REENDER_DEALDANGER = "reins.reinsout.reendor.dealdanger";

    /** 分赔案处理 */
    public static final String TASK_REINSOUT_REPAY = "reins.reinsout.repay";

    /** 分赔案信息 */
    public static final String TASK_REINSOUT_REPAY_QUERY = "reins.reinsout.repay.query";

    /** 分保合约 */
    public static final String TASK_REINSOUT_REPAY_QUERY_TREATY = "reins.reinsout.repay.query.treaty";

    /** 分保临分 */
    public static final String TASK_REINSOUT_REPAY_QUERY_FACACC = "reins.reinsout.repay.query.facacc";

    /** 分保复核 */
    public static final String TASK_REINSOUT_REPAY_UNDERWRITE = "reins.reinsout.repay.underwrite";

    /** 单证打印 */
    public static final String TASK_REINSOUT_REPAY_PRINT = "reins.reinsout.repay.print";

    /** 危险单位处理 */
    public static final String TASK_REINSOUT_REPAY_DEALDANGER = "reins.reinsout.repay.dealdanger";

    /** 现金赔款帐单 */
    public static final String TASK_REINSOUT_REPAY_COSTREPAY = "reins.reinsout.repay.costrepay";

    /** 分赔案单证打印 */
    public static final String TASK_REINSOUT_REPAY_CREDENCE = "reins.reinsout.repay.print.credence";

    /** 临分帐务 */
    public static final String TASK_REINSOUT_FACACC = "reins.reinsout.facacc";

    /** 分保单帐单生成 */
    public static final String TASK_REINSOUT_FACACC_REPOLICY = "reins.reinsout.facacc.repolicy";

    /** 分批单帐单生成 */
    public static final String TASK_REINSOUT_FACACC_REENDOR = "reins.reinsout.facacc.reendor";
    /** 分赔案帐单生成 */
    ;

    public static final String TASK_REINSOUT_FACACC_REPAY = "reins.reinsout.facacc.repay";

    /** 帐单维护 */
    public static final String TASK_REINSOUT_FACACC_MAINTENANCE = "reins.reinsout.facacc.maintenance";

    /** 分保单 */
    public static final String TASK_REINSOUT_FACACC_MAINTENANCE_REPOLICY = "reins.reinsout.facacc.maintenance.repolicy";

    /** 分批单 */
    public static final String TASK_REINSOUT_FACACC_MAINTENANCE_REENDOR = "reins.reinsout.facacc.maintenance.reendor";

    /** 分赔案 */
    public static final String TASK_REINSOUT_FACACC_MAINTENANCE_REPAY = "reins.reinsout.facacc.maintenance.repay";

    /** 帐单确认 */
    public static final String TASK_REINSOUT_FACACC_CONFIRM = "reins.reinsout.facacc.confirm";

    /** 帐单合并打印 */
    public static final String TASK_REINSOUT_FACACC_UNITEPRINT = "reins.reinsout.facacc.uniteprint";

    /** 临分保批清单 */
    public static final String TASK_REINSOUT_FACACC_REPOLICYREENDORPRINT = "reins.reinsout.facacc.repolicyreendorprint";

    /** 临分赔款清单 */
    public static final String TASK_REINSOUT_FACACC_REPAYPRINT = "reins.reinsout.facacc.repayprint";

    /** 合约帐务 */
    public static final String TASK_REINSOUT_TTYACC = "reins.reinsout.ttyacc";

    /** 帐单生成 */
    public static final String TASK_REINSOUT_TTYACC_CREATEACC = "reins.reinsout.ttyacc.createacc";

    /** 帐单维护 */
    public static final String TASK_REINSOUT_TTYACC_MAINTENANCE = "reins.reinsout.ttyacc.maintenance";

    /** 帐单确认 */
    public static final String TASK_REINSOUT_TTYACC_CONFIRM = "reins.reinsout.ttyacc.confirm";

    /** 单证打印 */
    public static final String TASK_REINSOUT_TTYACC_PRINT = "reins.reinsout.ttyacc.print";

    /** 对内帐单 */
    public static final String TASK_REINSOUT_TTYACC_PRINT_OUTSIDE = "reins.reinsout.ttyacc.print.outside";

    /** 对外帐单 */
    public static final String TASK_REINSOUT_TTYACC_PRINT_INSIDE = "reins.reinsout.ttyacc.print.inside";

    /** 明细帐处理 */
    public static final String TASK_REINSOUT_TTYACC_DEALDETAIL = "reins.reinsout.ttyacc.dealdetail";

    /** 产品管理 */
    public static final String TASK_REINSOUT_PRODUCT = "reins.reinsout.product";

    /** 合约管理 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY = "reins.reinsout.product.treaty";

    /** 单号初始化 */
    public static final String TASK_REINSOUT_PRODUCT_INITIALIZE = "reins.reinsout.product.initialize";

    /** 代码管理 */
    public static final String TASK_REINSOUT_PRODUCT_MANAGECODE = "reins.reinsout.product.managecode";

    /** 合约录入 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY_IMPORT = "reins.reinsout.product.treaty.import";

    /** 合约维护 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY_MAINTENANCE = "reins.reinsout.product.treaty.maintenance";

    /** 合约帐单期维护 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY_PERIODMAINTENANCE = "reins.reinsout.product.treaty.periodmaintenance";

    /** 自留额计划维护 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY_PLANMAINTENANCE = "reins.reinsout.product.treaty.planmaintenance";

    /** 特殊合约录入 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY_SPECIMPORT = "reins.reinsout.product.treaty.specimport";

    /** 权重系数维护 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY_COEFF = "reins.reinsout.product.treaty.coeff";

    /** 合约优先级维护 */
    public static final String TASK_REINSOUT_PRODUCT_TREATY_LEVEL = "reins.reinsout.product.treaty.level";

    /** 分保接受人 */
    public static final String TASK_REINSOUT_PRODUCT_MANAGECODE_ACCEPT = "reins.reinsout.product.managecode.accept";

    /** 科目与帐单信息 */
    public static final String TASK_REINSOUT_PRODUCT_MANAGECODE_SUBJECT = "reins.reinsout.product.managecode.subject";

    /** 查询生成危险单位 */
    public static final String TASK_REINSOUT_PRODUCT_MANAGECODE_DANGEROUS = "reins.reinsout.product.managecode.dangerous";

    /** 分入确认 */
    public static final String TASK_REINSIN_CONFIRM = "reins.reinsin.confirm";

    /** 临分分入业务 */
    public static final String TASK_REINSIN_FAC = "reins.reinsin.fac";

    /** 分入分保单 */
    public static final String TASK_REINSIN_FAC_REPOLICY = "reins.reinsin.fac.repolicy";

    /** 分入分批单 */
    public static final String TASK_REINSIN_FAC_REENDOR = "reins.reinsin.fac.reendor";

    /** 分入分赔案 */
    public static final String TASK_REINSIN_FAC_REPAY = "reins.reinsin.fac.repay";

    /** 临分分入帐务 */
    public static final String TASK_REINSIN_FACACC = "reins.reinsin.facacc";

    /** 帐单维护 */
    public static final String TASK_REINSIN_FACACC_MAINTENANCE = "reins.reinsin.facacc.maintenance";

    /** 帐单生成 */
    public static final String TASK_REINSIN_FACACC_MAINTENANCE_CREATE = "reins.reinsin.facacc.maintenance.create";

    /** 帐单删除 */
    public static final String TASK_REINSIN_FACACC_MAINTENANCE_DELETE = "reins.reinsin.facacc.maintenance.delete";

    /** 帐单确认 */
    public static final String TASK_REINSIN_FACACC_MAINTENANCE_CONFIRM = "reins.reinsin.facacc.maintenance.confirm";

    /** 帐单确认 */
    public static final String TASK_REINSIN_FACACC_CONFIRM = "reins.reinsin.facacc.confirm";

}