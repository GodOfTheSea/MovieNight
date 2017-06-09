/**
 * Created by pinte on 5/18/2017.
 */
function setColor(e) {
    var target = e.target,
        count = +target.dataset.count;

    target.style.backgroundColor = count === 1 ? "#e50914" : '#b3b3b3';
    target.dataset.count = count === 1 ? 0 : 1;
}

