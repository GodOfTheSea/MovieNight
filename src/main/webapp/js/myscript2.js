/**
 * Created by pinte on 5/23/2017.
 */
function setColorMale(e) {
    var target = e.target,
        count = +target.dataset.count;

    target.style.backgroundColor = count === 1 ? "#0080ff" : '#b3b3b3';
    target.dataset.count = count === 1 ? 0 : 1;
}