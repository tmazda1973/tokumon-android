package jp.thinkware.tokumon.app.dao;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.QuestionCategoryDto;

/**
 * DBレコードのDAOインターフェースクラスです。(設問カテゴリテーブル)
 * @author thinkware
 */
public interface QuestionCategoryDao {

	/**
	 * DBにレコードを新規追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(QuestionCategoryDto dto);

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void update(QuestionCategoryDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void delete(QuestionCategoryDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param conditionMap 抽出条件マップ
	 * @return なし
	 */
	public void delete(Map<String, Object> conditionMap);

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<QuestionCategoryDto> selectList(Map<String, Object> conditionMap);
}